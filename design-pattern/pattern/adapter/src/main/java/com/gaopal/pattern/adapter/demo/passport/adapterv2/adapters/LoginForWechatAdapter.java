package com.gaopal.pattern.adapter.demo.passport.adapterv2.adapters;

import com.gaopal.pattern.adapter.demo.passport.ResultMsg;

public class LoginForWechatAdapter extends AbstraceAdapter {
  public boolean support(Object adapter) {
    return adapter instanceof LoginForWechatAdapter;
  }

  public ResultMsg login(String id, Object adapter) {
    return super.loginForRegist(id, null);
  }
}
