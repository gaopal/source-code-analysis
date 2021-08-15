package com.gaopal.java.c10_features.jdk8;

import java.util.function.Consumer;

/**
 * 内置4个函数式接口
 * 1. 消费型接口:
 * Consumer<T> - void accept(T t)
 *
 * 2. 供给型接口
 * Supplier<T> - T get()
 *
 * 3. 函数型接口
 * Function<T, R> R apply(T t)
 *
 * 4. 断言型接口 断定型接口
 * Predicate<T> boolean test(T t)
 */
public class TestLambdaInterface04 {
//    public static void bath1(double money, SpendMoney sm) {
//        sm.buy(money);
//    }

    public static void bath2(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    public static void main(String[] args) {
//      bath1(2990, new SpendMoney() {
//          @Override
//          public void buy(double money) {
//              System.out.println("花了" + money + "元");
//          }
//      });

      bath2(2990, new Consumer<Double>() {
          @Override
          public void accept(Double aDouble) {
              System.out.println("花了" + aDouble + "元");
          }
      });

      bath2(2990, x -> System.out.println("花了" + x + "元"));
    }
}

// 消费
//interface SpendMoney {
//    void buy(double money);
//}
