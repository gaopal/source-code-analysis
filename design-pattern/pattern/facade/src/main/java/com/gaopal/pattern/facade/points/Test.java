package com.gaopal.pattern.facade.points;

public class Test {

  public static void main(String[] args) {

    GiftFacadeService facadeService = new GiftFacadeService();

    GiftInfo giftInfo = new GiftInfo("《Spring 5核心原理》");

    facadeService.exchange(giftInfo);
  }
}
