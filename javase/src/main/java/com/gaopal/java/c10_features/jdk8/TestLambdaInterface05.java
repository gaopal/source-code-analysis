package com.gaopal.java.c10_features.jdk8;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * 方法引用:
 *
 * 3种使用情况:
 *
 * 1. 对象::实例方法名(费静态方法)
 * 2. 类::静态方法名
 * 3. 类::实例方法名
 */
public class TestLambdaInterface05 {
  public static void main(String[] args) {
    // 消费型接口
    Consumer<String> consumer = x -> System.out.println(x);
    consumer.accept("消费型接口方法");

    /**
     * Consumer方法: void accept(T t)
     * 方法体用的方法: void println(String x)
     * 如果你满足: 函数式接口的参数和返回值
     * 与
     * 具体的方法体实现中的方法的 参数和返回值如果一致,可以使用方法引用
     */
    Consumer<String> consumer2 = System.out::println;
    consumer2.accept("方法引用");

    /**
     * 类::静态方法名
     */
    Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    comparator.compare(12, 80);

    Comparator<Integer> comparator2 = Integer::compare;
    comparator2.compare(12, 80);

    /**
     * 类::实例方法名
     * 方法引用的前提:x作为方法的调用者,y作为方法的实际参数
     */
    BiPredicate<String, String> bp = (x, y) -> x.equals(y);
    System.out.println(bp.test("abc","abc"));

    BiPredicate<String, String> bp2 = String::equals;
    System.out.println(bp2.test("abc","abc"));
  }
}
