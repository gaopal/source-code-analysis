package com.gaopal.pattern.chain.auth.builderchain;

import com.gaopal.pattern.chain.auth.Member;

public class MemberService {

  public void login(String loginName, String loginPass) {

    Handler.Builder builder = new Handler.Builder();

    builder
        .addHandler(new ValidateHandler())
        .addHandler(new LoginHandler())
        .addHandler(new AuthHandler());

    builder.build().doHandler(new Member(loginName, loginPass));
  }
}
