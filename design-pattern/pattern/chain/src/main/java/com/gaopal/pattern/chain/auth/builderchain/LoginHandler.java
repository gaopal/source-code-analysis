package com.gaopal.pattern.chain.auth.builderchain;

import com.gaopal.pattern.chain.auth.Member;

public class LoginHandler extends Handler {
  public void doHandler(Member member) {
    System.out.println("登录成功！");
    member.setRoleName("管理员");
    next.doHandler(member);
  }
}
