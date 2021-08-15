package com.gaopal.pattern.proxy.dbroute.db;

/** Created by gaopal on 2019/3/10. */
public class DynamicDataSourceEntity {

  public static final String DEFAULE_SOURCE = null;

  private static final ThreadLocal<String> local = new ThreadLocal<String>();

  private DynamicDataSourceEntity() {}

  public static String get() {
    return local.get();
  }

  public static void restore() {
    local.set(DEFAULE_SOURCE);
  }

  // DB_2018
  // DB_2019
  public static void set(String source) {
    local.set(source);
  }

  public static void set(int year) {
    local.set("DB_" + year);
  }
}
