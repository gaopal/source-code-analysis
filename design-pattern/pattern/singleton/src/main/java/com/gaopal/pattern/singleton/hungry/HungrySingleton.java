package com.gaopal.pattern.singleton.hungry;

import java.io.*;

/** 饿汉式静态代码块单例模式 优点：执行效率高，性能高，没有任何的锁 缺点：某些情况下，可能会造成内存浪费 */
public class HungrySingleton {
  private static final HungrySingleton instance = new HungrySingleton();

  private HungrySingleton() {}

  public static HungrySingleton getInstance() {
    return instance;
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    HungrySingleton originSingleton = HungrySingleton.getInstance();
    System.out.println("-----------序列化----------------------");
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(originSingleton);
    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);
    HungrySingleton serializeSingleton = (HungrySingleton) ois.readObject();
    System.out.println(originSingleton == serializeSingleton); // false
  }
}
