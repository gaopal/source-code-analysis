package com.gaopal.pattern.state.gper;

public class LoginState extends UserState {
  @Override
  public void favorite() {
    System.out.println("收藏成功！");
  }

  @Override
  public void comment(String comment) {
    System.out.println(comment);
  }
}
