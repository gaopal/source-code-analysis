package com.gaopal.pattern.adapter.demo.passport.adapterv2.adapters;

import com.gaopal.pattern.adapter.demo.passport.PassportService;
import com.gaopal.pattern.adapter.demo.passport.ResultMsg;

public abstract class AbstraceAdapter extends PassportService implements ILoginAdapter {
  protected ResultMsg loginForRegist(String username, String password) {
    if (null == password) {
      password = "THIRD_EMPTY";
    }
    super.regist(username, password);
    return super.login(username, password);
  }
}
