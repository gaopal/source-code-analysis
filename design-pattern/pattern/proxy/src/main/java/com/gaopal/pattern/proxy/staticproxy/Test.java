package com.gaopal.pattern.proxy.staticproxy;

public class Test {
  public static void main(String[] args) {
    ZhangLaosan zhangLaosan = new ZhangLaosan(new ZhangSan());
    zhangLaosan.findLove();
  }
}
