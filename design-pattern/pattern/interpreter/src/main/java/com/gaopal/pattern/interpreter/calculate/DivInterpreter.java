package com.gaopal.pattern.interpreter.calculate;

/** 除法 Created by gaopal */
public class DivInterpreter extends Interpreter {
  public DivInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
    super(left, right);
  }

  public int interpret() {
    return this.left.interpret() / this.right.interpret();
  }
}
