package com.gaopal.uml.classdiagrams.aggregate;

/** Created by gaopal */
public class BusDriver {
  private Clothes clothes;
  private Hat hat;

  public void setClothes(Clothes clothes) {
    this.clothes = clothes;
  }

  public void setHat(Hat hat) {
    this.hat = hat;
  }

  public void show() {}
}
