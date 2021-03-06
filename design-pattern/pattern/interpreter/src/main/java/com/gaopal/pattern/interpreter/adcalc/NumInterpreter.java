package com.gaopal.pattern.interpreter.adcalc;

/** 终结表达式 Created by gaopal */
public class NumInterpreter implements IArithmeticInterpreter {
  private int value;

  public NumInterpreter(int value) {
    this.value = value;
  }

  public int interpret() {
    return this.value;
  }
}
