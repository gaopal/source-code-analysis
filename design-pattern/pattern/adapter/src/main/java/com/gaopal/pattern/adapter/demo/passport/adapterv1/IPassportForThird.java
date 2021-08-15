package com.gaopal.pattern.adapter.demo.passport.adapterv1;

import com.gaopal.pattern.adapter.demo.passport.ResultMsg;

public interface IPassportForThird {

  ResultMsg loginForQQ(String openId);

  ResultMsg loginForWechat(String openId);

  ResultMsg loginForToken(String token);

  ResultMsg loginForTelphone(String phone, String code);
}
