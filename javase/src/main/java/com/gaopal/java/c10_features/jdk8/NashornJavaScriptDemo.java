package com.gaopal.java.c10_features.jdk8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Nashorn JavaScript Engine 在 Java 15 已经不可用了。 * *
 *
 * <p>这已经在 Java 11 标记为： * @deprecated (forRemoval = true) 从 JDK 1.8 开始，Nashorn取代Rhino(JDK 1.6,
 * JDK1.7) 成为 Java 的嵌入式 JavaScript 引擎。Nashorn 完全支持 ECMAScript 5.1 规范以及一些扩展。它使用基于 JSR 292
 * 的新语言特性，其中包含在 JDK 7 中引入的 invokedynamic，将 JavaScript 编译成 Java 字节码。
 *
 * <p>与先前的 Rhino 实现相比，这带来了 2 到 10倍的性能提升。
 */
public class NashornJavaScriptDemo {
  public static void main(String args[]) {

    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

    String name = "Runoob";
    Integer result = null;

    try {
      nashorn.eval("print('" + name + "')");
      result = (Integer) nashorn.eval("10 + 2");

    } catch (ScriptException e) {
      System.out.println("执行脚本错误: " + e.getMessage());
    }

    System.out.println(result.toString());
  }
}
