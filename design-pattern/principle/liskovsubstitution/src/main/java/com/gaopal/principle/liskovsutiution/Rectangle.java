package com.gaopal.principle.liskovsutiution;

/** Created by gaopal on 2020/2/16. */
public class Rectangle implements QuadRangle {
  private long height;
  private long width;

  public long getHeight() {
    return height;
  }

  public void setHeight(long height) {
    this.height = height;
  }

  public long getWidth() {
    return width;
  }

  public void setWidth(long width) {
    this.width = width;
  }
}