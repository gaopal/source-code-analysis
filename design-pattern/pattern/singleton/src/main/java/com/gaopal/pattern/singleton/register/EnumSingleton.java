package com.gaopal.pattern.singleton.register;


public enum EnumSingleton {
  INSTANCE;
  private Object data;

  public static EnumSingleton getInstance() {
    return INSTANCE;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
