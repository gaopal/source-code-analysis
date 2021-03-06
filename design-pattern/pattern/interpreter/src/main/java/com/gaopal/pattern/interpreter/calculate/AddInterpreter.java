package com.gaopal.pattern.interpreter.calculate;

/** 加法 Created by gaopal */
public class AddInterpreter extends Interpreter {
  public AddInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
    super(left, right);
  }

  public int interpret() {
    return this.left.interpret() + this.right.interpret();
  }
}
