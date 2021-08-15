package com.gaopal.principle.compositereuse;

/** Created by gaopal on 2020/2/17. */
public class MyOracleConnection extends DBConnection {
  public String getConnection() {
    return "获取Oracle数据连接";
  }
}
