package com.gaopal.java.c10_features.jdk8;

/**
 * 结构2: 有参 无返回值
 */
public interface TestLambdaInterface02 {
  void testMethod(int num);
}

class ParamDemo {
  public static void main(String[] args) {
    /**
     * 总结：
     * 1. 方法体只有一句话的时候,花括号可以省略不写
     * 2. 参数名称可以随便命名
     * 3. 参数的类型可以省略  -> 上下文有类型推断
     * 4. 参数只有一个的时候,括号可以省略
     */
    TestLambdaInterface02 testInterface2 = x -> System.out.println("Lambda实现了游蚕无返回值的testMethod方法");
    testInterface2.testMethod(10);
  }
}