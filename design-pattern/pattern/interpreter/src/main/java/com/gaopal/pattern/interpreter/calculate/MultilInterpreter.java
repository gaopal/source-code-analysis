package com.gaopal.pattern.interpreter.calculate;

/** 乘法 Created by gaopal */
public class MultilInterpreter extends Interpreter {
  public MultilInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
    super(left, right);
  }

  public int interpret() {
    return this.left.interpret() * this.right.interpret();
  }
}
