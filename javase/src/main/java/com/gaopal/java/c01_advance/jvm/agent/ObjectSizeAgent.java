package com.gaopal.java.c01_advance.jvm.agent;

import java.lang.instrument.Instrumentation;

public class ObjectSizeAgent {
  private static Instrumentation inst;

  public static void premain(String agentArgs, Instrumentation _inst) {
    inst = _inst;
  }

  public static long sizeOf(Object o) {
    return inst.getObjectSize(o);
  }
}
