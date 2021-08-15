package com.gaopal.pattern.singleton.test;

import com.gaopal.pattern.singleton.register.EnumSingleton;

import java.lang.reflect.Constructor;


public class EnumSingletonTest {
  public static void main(String[] args) {
    //        EnumSingleton instance = EnumSingleton.getInstance();
    //        instance.setData(new Object());

    try {
      Class clazz = EnumSingleton.class;

      Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
      c.setAccessible(true);
      //            System.out.println(c);
      Object o = c.newInstance();
      //            System.out.println(o);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
