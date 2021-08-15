package com.gaopal.principle.liskovsutiution.methodreturn;

/** Created by gaopal on 2020/2/16. */
public class MethodReturnTest {
  public static void main(String[] args) {
    Base child = new Child();
    System.out.println(child.method());
  }
}
