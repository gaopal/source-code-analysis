package com.gaopal.pattern.strategy.promotion;


public class EmptyStrategy implements IPromotionStrategy {
  public void doPromotion() {
    System.out.println("无优惠");
  }
}
