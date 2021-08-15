package com.gaopal.pattern.singleton.lazy;



/** 懒汉双重检查式 优点:性能高了，线程安全了 缺点：可读性难度加大，不够优雅 */
public class LazyDoubleCheckSingleton {
  private static volatile LazyDoubleCheckSingleton instance;

  private LazyDoubleCheckSingleton() {}

  public static LazyDoubleCheckSingleton getInstance() {
    // 检查是否要阻塞
    if (instance == null) {
      synchronized (LazyDoubleCheckSingleton.class) {
        // 检查是否要重新创建实例
        if (instance == null) {
          // 指令重排序的问题
          instance = new LazyDoubleCheckSingleton();
        }
      }
    }
    return instance;
  }
}
