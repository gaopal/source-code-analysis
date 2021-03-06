package com.gaopal.pattern.interpreter.calculate;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


public class SpringTest {
  public static void main(String[] args) {
    ExpressionParser parser = new SpelExpressionParser();
    Expression expression = parser.parseExpression("100 * 2 + 400 * 1 + 66");
    Integer result = (Integer) expression.getValue();
    System.out.println("计算结果是：" + result);
  }
}
