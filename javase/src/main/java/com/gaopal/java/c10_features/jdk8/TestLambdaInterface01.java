package com.gaopal.java.c10_features.jdk8;

/**
 * 语法结构1:无参 无返回值
 */
public interface TestLambdaInterface01 {
  void testMethod();
}

class Demo{
  public static void main(String[] args) {
    // 创建接口对应的实现类对象
    TestLambdaInterface01 testInterface = new TestLambdaInterface01(){
      @Override
      public void testMethod() {
        System.out.println("重新实现了testMethod方法");
      }
    };
    testInterface.testMethod();

    /**
     * 总结：
     * 1. Lambda表达式是一种新的语法结构
     * 2. 语法层面简洁了
     * 3. 先睹为快 -》 Lambda表达式的本质就是：接口的实现类的具体对象
     * 4. 应用场合：复用性没有那么强的时候
     * 5. 语法：
     * -> 箭头操作符 Lambda操作符
     * -> 左侧：Lambda的形参列表  -》等效于对应接口抽象方法的形参列表
     * -> 右侧：抽象方法的方法体
     */
    TestLambdaInterface01 testInterface2 = () -> System.out.println("Lambda实现了无参无返回值的testMethod方法");
    testInterface2.testMethod();
  }
}