package com.gaopal.pattern.interpreter.calculate;


public class Test {

  public static void main(String[] args) {
    System.out.println("result:" + new GPCalculator("10 + 30").calulate());
    System.out.println("result:" + new GPCalculator("10 + 30 - 20").calulate());
    System.out.println("result:" + new GPCalculator("100 * 2 + 400 * 2 + 66").calulate());
  }
}
