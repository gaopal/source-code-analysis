package com.gaopal.principle.compositereuse;

/** Created by gaopal on 2020/2/17. */
public class MySQLConnection extends DBConnection {
  public String getConnection() {
    return "获取MySQL数据连接";
  }
}
