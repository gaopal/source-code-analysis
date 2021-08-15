package com.gaopal.pattern.strategy.promotion;


public class CouponStrategy implements IPromotionStrategy {
  public void doPromotion() {
    System.out.println("使用优惠券抵扣");
  }
}
