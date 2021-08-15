package com.gaopal.principle.liskovsutiution;

/** Created by gaopal on 2020/2/16. */
public class Square implements QuadRangle {
  private long length;

  public long getLength() {
    return length;
  }

  public void setLength(long length) {
    this.length = length;
  }

  public long getWidth() {
    return length;
  }

  public long getHeight() {
    return length;
  }
}
