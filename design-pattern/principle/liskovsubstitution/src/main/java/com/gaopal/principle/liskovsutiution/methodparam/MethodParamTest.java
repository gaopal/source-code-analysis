package com.gaopal.principle.liskovsutiution.methodparam;

import java.util.HashMap;

/** Created by gaopal on 2020/2/16. */
public class MethodParamTest {
  public static void main(String[] args) {
    Base child = new Child();
    HashMap hashMap = new HashMap();
    child.method(hashMap);
  }
}
