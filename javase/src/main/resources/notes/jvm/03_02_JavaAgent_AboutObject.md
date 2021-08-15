# 使用JavaAgent测试Object的大小

## 对象大小（64位机）

### 观察虚拟机配置

java -XX:+PrintCommandLineFlags -version

### 对象布局

### 普通对象

1. 对象头：markword  8
2. ClassPointer指针：-XX:+UseCompressedClassPointers 为4字节 不开启为8字节
3. 实例数据
   1. 引用类型：-XX:+UseCompressedOops 为4字节 不开启为8字节
      Oops Ordinary Object Pointers
4. Padding对齐，8的倍数

### 数组对象

1. 对象头：markword 8
2. ClassPointer指针同上
3. 数组长度：4字节
4. 数组数据
5. 对齐 8的倍数

### Markword内容

openJDK：src/hotspot/share/oops/markOop.hpp

```cpp
//  32 bits:
//  --------
//             hash:25 ------------>| age:4    biased_lock:1 lock:2 (normal object)
//             JavaThread*:23 epoch:2 age:4    biased_lock:1 lock:2 (biased object)
//             size:32 ------------------------------------------>| (CMS free block)
//             PromotedObject*:29 ---------->| promo_bits:3 ----->| (CMS promoted object)
//
//  64 bits:
//  --------
//  unused:25 hash:31 -->| unused:1   age:4    biased_lock:1 lock:2 (normal object)
//  JavaThread*:54 epoch:2 unused:1   age:4    biased_lock:1 lock:2 (biased object)
//  PromotedObject*:61 --------------------->| promo_bits:3 ----->| (CMS promoted object)
//  size:64 ----------------------------------------------------->| (CMS free block)
//
//  - the two lock bits are used to describe three states: locked/unlocked and monitor.
//
//    [ptr             | 00]  locked             ptr points to real header on stack
//    [header      | 0 | 01]  unlocked           regular object header
//    [ptr             | 10]  monitor            inflated lock (header is wapped out)
//    [ptr             | 11]  marked             used by markSweep to mark an object
//                                               not valid at any other time
```

64位：

![](http://aliyun-mweb-oss.oss-cn-shanghai.aliyuncs.com/2021/03/18/16160562009487.jpg)

<table style="text-align:center">
  <caption>Java 64位对象布局</caption>
  <tr>
    <td colspan="8">Object Header(128bits)</td>
  </tr>
  <tr>
    <td colspan="6">Mark Word(64bits)</td>
    <td>Klass Word(64bits)</td>
    <td>状态说明</td>
  </tr>
  <tr>
    <td>unused:25</td>
    <td>identity_hashcode:31</td>
    <td>unused:1</td>
    <td>age:4</td>
    <td>是否偏向锁:1</td>
    <td>lock:2</td>
    <td>OOP to metadata object</td>
    <td>无锁</td>
  </tr>
  <tr>
    <td>thread:54</td>
    <td>epoch:2</td>
    <td>unused:1</td>
    <td>age:4</td>
    <td>是否偏向锁:1</td>
    <td>lock:2</td>
    <td>OOP to metadata object</td>
    <td>偏向锁</td>
  </tr>
  <tr>
    <td colspan="5">ptr_to_lock_record:62</td>
    <td>lock:2</td>
    <td>OOP to metadata object</td>
    <td>轻量级锁</td>
  </tr>
  <tr>
    <td colspan="5">ptr_to_heavyweight_monitor:62</td>
    <td>lock:2</td>
    <td>OOP to metadata object</td>
    <td>重量级锁</td>
  </tr>
  <tr>
    <td colspan="5">unused:62</td>
    <td>lock:2</td>
    <td>OOP to metadata object</td>
    <td>GC标记</td>
  </tr>
</table>

32位：

```
biased_lock：对象是否启用偏向锁标记，只占1个二进制位。为1时表示对象启用偏向锁，为0时表示对象没有偏向锁。lock和biased_lock共同表示对象处于什么锁状态。

age：4位的Java对象年龄。在GC中，如果对象在Survivor区复制一次，年龄增加1。当对象达到设定的阈值时，将会晋升到老年代。默认情况下，并行GC的年龄阈值为15，并发GC的年龄阈值为6。由于age只有4位，所以最大值为15，这就是-XX:MaxTenuringThreshold选项最大值为15的原因。

identity_hashcode：31位的对象标识hashCode，采用延迟加载技术。调用方法System.identityHashCode()计算，并会将结果写到该对象头中。当对象加锁后（偏向、轻量级、重量级），MarkWord的字节没有足够的空间保存hashCode，因此该值会移动到管程Monitor中。

thread：持有偏向锁的线程ID。

epoch：偏向锁的时间戳。

ptr_to_lock_record：轻量级锁状态下，指向栈中锁记录的指针。

ptr_to_heavyweight_monitor：重量级锁状态下，指向对象监视器Monitor的指针。

我们通常说的通过synchronized实现的同步锁，真实名称叫做重量级锁。但是重量级锁会造成线程排队（串行执行），且会使CPU在用户态和核心态之间频繁切换，所以代价高、效率低。为了提高效率，不会一开始就使用重量级锁，JVM在内部会根据需要，按如下步骤进行锁的升级：
1，当没有被当成锁时，这就是一个普通的对象，Mark Word记录对象的HashCode，锁标志位是01，是否偏向锁那一位是0。
2，当对象被当做同步锁并有一个线程A抢到了锁时，锁标志位还是01，但是否偏向锁那一位改成1，前23bit记录抢到锁的线程id，表示进入偏向锁状态。
3，当线程A再次试图来获得锁时，JVM发现同步锁对象的标志位是01，是否偏向锁是1，也就是偏向状态，Mark Word中记录的线程id就是线程A自己的id，表示线程A已经获得了这个偏向锁，可以执行同步锁的代码。
4，当线程B试图获得这个锁时，JVM发现同步锁处于偏向状态，但是Mark Word中的线程id记录的不是B，那么线程B会先用CAS操作试图获得锁，这里的获得锁操作是有可能成功的，因为线程A一般不会自动释放偏向锁。如果抢锁成功，就把Mark Word里的线程id改为线程B的id，代表线程B获得了这个偏向锁，可以执行同步锁代码。如果抢锁失败，则继续执行步骤5。
5，偏向锁状态抢锁失败，代表当前锁有一定的竞争，偏向锁将升级为轻量级锁。JVM会在当前线程的线程栈中开辟一块单独的空间，里面保存指向对象锁Mark Word的指针，同时在对象锁Mark Word中保存指向这片空间的指针。上述两个保存操作都是CAS操作，如果保存成功，代表线程抢到了同步锁，就把Mark Word中的锁标志位改成00，可以执行同步锁代码。如果保存失败，表示抢锁失败，竞争太激烈，继续执行步骤6。
6，轻量级锁抢锁失败，JVM会使用自旋锁，自旋锁不是一个锁状态，只是代表不断的重试，尝试抢锁。从JDK1.7开始，自旋锁默认启用，自旋次数由JVM决定。如果抢锁成功则执行同步锁代码，如果失败则继续执行步骤7。
7，自旋锁重试之后如果抢锁依然失败，同步锁会升级至重量级锁，锁标志位改为10。在这个状态下，未抢到锁的线程都会被阻塞。

1.初期锁对象刚创建时，还没有任何线程来竞争，对象的Mark Word是下图的第一种情形，这偏向锁标识位是0，锁状态01，说明该对象处于无锁状态（无线程竞争它）。
2.当有一个线程来竞争锁时，先用偏向锁，表示锁对象偏爱这个线程，这个线程要执行这个锁关联的任何代码，不需要再做任何检查和切换，这种竞争不激烈的情况下，效率非常高。这时Mark Word会记录自己偏爱的线程的ID，把该线程当做自己的熟人。如下图第二种情形。
3.当有两个线程开始竞争这个锁对象，情况发生变化了，不再是偏向（独占）锁了，锁会升级为轻量级锁，两个线程公平竞争，哪个线程先占有锁对象并执行代码，锁对象的Mark Word就执行哪个线程的栈帧中的锁记录。如下图第三种情形。
4.如果竞争的这个锁对象的线程更多，导致了更多的切换和等待，JVM会把该锁对象的锁升级为重量级锁，这个就叫做同步锁，这个锁对象Mark Word再次发生变化，会指向一个监视器对象，这个监视器对象用集合的形式，来登记和管理排队的线程。如下图第四种情形。
```

参考资料：
https://blog.csdn.net/qq_26542493/article/details/90938070
https://blog.csdn.net/qq_36434742/article/details/106854061
https://www.jianshu.com/p/823b0939fc31
https://www.freesion.com/article/72141183517/
https://blog.csdn.net/qq_33762302/article/details/113748613

## 实验

1. 新建项目ObjectSize （1.8）

2. 创建文件ObjectSizeAgent

    ```java
    package com.gaopal.jvm.agent;

    import java.lang.instrument.Instrumentation;

    public class ObjectSizeAgent {
        private static Instrumentation inst;

        public static void premain(String agentArgs, Instrumentation _inst) {
            inst = _inst;
        }

        public static long sizeOf(Object o) {
            return inst.getObjectSize(o);
        }
    }
    ```

3. src目录下创建META-INF/MANIFEST.MF

   ```yaml
   Manifest-Version: 1.0
   Created-By: gaopal.com
   Premain-Class: com.gaopal.jvm.agent.ObjectSizeAgent
   ```

   注意Premain-Class这行必须是新的一行（回车 + 换行），确认idea不能有任何错误提示

4. 打包jar文件

5. 在需要使用该Agent Jar的项目中引入该Jar包
   project structure - project settings - library 添加该jar包

6. 运行时需要该Agent Jar的类，加入参数：

```cmd
-javaagent:/Users/gaopengfei/private/tools/ObjectSize.jar
```

7. 如何使用该类：

```java
package com.gaopal.jvm.c3_jmm;

import com.gaopal.jvm.agent.ObjectSizeAgent;

public class T03_SizeOfAnObject {
  public static void main(String[] args) {
    System.out.println(ObjectSizeAgent.sizeOf(new Object()));
    System.out.println(ObjectSizeAgent.sizeOf(new int[] {}));
    System.out.println(ObjectSizeAgent.sizeOf(new P()));
  }

  private static class P {
                    //8 _markword
                    //4 _oop指针
    int id;         //4
    String name;    //4
    int age;        //4

    byte b1;        //1
    byte b2;        //1

    Object o;       //4
    byte b3;        //1
  }
}
```

## Hotspot开启内存压缩的规则（64位机）

1. 4G以下，直接砍掉高32位
2. 4G - 32G，默认开启内存压缩 ClassPointers Oops（Ordinary Object Pointers）
3. 32G，压缩无效，使用64位
   内存并不是越大越好

## IdentityHashCode的问题

回答白马非马的问题：

当一个对象计算过identityHashCode之后，不能进入偏向锁状态

https://cloud.tencent.com/developer/article/1480590
https://cloud.tencent.com/developer/article/1484167
https://cloud.tencent.com/developer/article/1485795
https://cloud.tencent.com/developer/article/1482500

## 对象定位

•https://blog.csdn.net/clover_lily/article/details/80095580

1. 句柄池
2. 直接指针