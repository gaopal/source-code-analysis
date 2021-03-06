package com.gaopal.pattern.strategy.promotion;


public class PromotionActivity {
  private IPromotionStrategy strategy;

  public PromotionActivity(IPromotionStrategy strategy) {
    this.strategy = strategy;
  }

  public void execute() {
    strategy.doPromotion();
  }
}
