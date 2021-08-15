package com.gaopal.pattern.strategy.pay;

import com.gaopal.pattern.strategy.pay.payport.PayStrategy;

public class Test {
  public static void main(String[] args) {
    Order order = new Order("1", "2020031401000323", 324.5);
    System.out.println(order.pay(PayStrategy.ALI_PAY));
  }
}
