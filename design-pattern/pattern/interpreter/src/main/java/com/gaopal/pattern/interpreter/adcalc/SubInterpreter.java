package com.gaopal.pattern.interpreter.adcalc;

/** 减法 Created by gaopal */
public class SubInterpreter extends Interpreter {
  public SubInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
    super(left, right);
  }

  public int interpret() {
    return this.left.interpret() - this.right.interpret();
  }
}
