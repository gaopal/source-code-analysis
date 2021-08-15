package com.gaopal.java.c01_advance.juc.c_000;

import java.util.concurrent.*;

/**
 * 创建线程的三种方式
 * 1：Thread
 * 2: Runnable
 * 3: Executors.newCachedThrad
 */
public class T02_HowToCreateThread {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    // 第1种方式
    // 继承Thread类,覆写run方法,创建该类对象,调用start方法开启线程,没有返回值
    Thread t1 = new Thread(){
      @Override
      public void run() {
        System.out.println("第1种方式:new Thread 1");
      }
    };
    t1.start();

    TimeUnit.SECONDS.sleep(1);

    // 第2种方式
    // 实现Runnable接口,覆写run方法,创建Thread类对象,将Run那边了子类对象传递给Thread对象,调用start方法
    // 将线程对象和线程任务对象分开,降低耦合性,此方法也没有返回值
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("第2种方式:new Thread 2");
      }
    });
    t2.start();

    TimeUnit.SECONDS.sleep(1);

    // 第3种方式
    // 创建FutureTask对象,创建Callable子类对象,覆写call方法
    FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
      @Override
      public String call() {
        return "FutureTask创建线程得到的返回结果";
      }
    });
    Thread t3 = new Thread(ft);
    t3.start();
    // 线程执行完，才会执行get()，所以FutureTask也可以用于闭锁
    String result = ft.get();
    System.out.println("第3种方式:new Thread 3返回结果 " + result);

    TimeUnit.SECONDS.sleep(1);

    // 第4种方式 线程池创建,submit提交
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    Future<String> future = executorService.submit(new Callable<String>(){
      @Override
      public String call() {
        return "有返回值";
      }
    });
    executorService.shutdown();
    System.out.println("第4种方式:线程池创建线程submit执行 new Thread 4,执行结果:" + future.get());

    // 第4种方式 线程池创建,execute执行
    ExecutorService executorService2 = Executors.newSingleThreadExecutor();
    executorService2.execute(()->{
      System.out.println("第5种方式:线程池创建线程execute执行 new Thread 5,无返回值");
    });
    executorService2.shutdown();
  }
}
