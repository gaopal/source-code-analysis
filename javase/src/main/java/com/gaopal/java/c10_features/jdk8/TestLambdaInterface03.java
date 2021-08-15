package com.gaopal.java.c10_features.jdk8;

/**
 * 语法结构3: 有多个参数,有返回值
 */
@FunctionalInterface
public interface TestLambdaInterface03 {
  int testMethod(int num, int size);
}

class Demo03 {
  public static void main(String[] args) {
    /**
     * 1. 如果多个参数的时候,括号不可以省略
     * 2. 方法体是多语句的,{} 也不可以省略
     */
    TestLambdaInterface03 testLambdaInterface03_01 = (x, y) -> {
      System.out.println("这是有参有返回值的testMethod:" +  x + "-------" + y);
      return 666;
    };
    testLambdaInterface03_01.testMethod(10, 20);

    /**
     * 方法体中只有return语句,return关键字和{}都可以省略
     * 总结: 能省则省
     *
     * Lambda表达式使用的那个接口,有个特点:里面只有一个抽象接口  -> 函数式接口
     * 通过注解 @FunctionalInterface 来限定函数式接口
     */
    TestLambdaInterface03 testLambdaInterface03_02 = (x, y) -> 666;
    testLambdaInterface03_02.testMethod(10, 20);
  }
}
