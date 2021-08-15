package com.gaopal.pattern.singleton.test;

import com.gaopal.pattern.singleton.lazy.LazyDoubleCheckSingleton;
import com.gaopal.pattern.singleton.lazy.LazySimpleSingletion;
import com.gaopal.pattern.singleton.threadlocal.ThreadLocalSingleton;


public class ExectorThread implements Runnable {

  public void run() {

    //        LazySimpleSingletion instance = LazySimpleSingletion.getInstance();
    LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
    //        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
    //        System.out.println(ThreadLocalSingleton.getInstance());
    System.out.println(Thread.currentThread().getName() + ":" + instance);
  }
}
