package com.gaopal.pattern.delegate.simple;

public class Boss {
  public void command(String task, Leader leader) {
    leader.doing(task);
  }
}
