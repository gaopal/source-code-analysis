package com.gaopal.pattern.interpreter.adcalc;

/** 非终结表达式 Created by gaopal */
public abstract class Interpreter implements IArithmeticInterpreter {

  protected IArithmeticInterpreter left;
  protected IArithmeticInterpreter right;

  public Interpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
    this.left = left;
    this.right = right;
  }
}
