package com.gaopal.principle.compositereuse;

/** Created by gaopal on 2020/2/17. */
public abstract class DBConnection {
  public abstract String getConnection();

  //    getConnection{
  //        return "获取MySQL数据连接";
  //    }
  //    public String getOracleConntion(){}
}
