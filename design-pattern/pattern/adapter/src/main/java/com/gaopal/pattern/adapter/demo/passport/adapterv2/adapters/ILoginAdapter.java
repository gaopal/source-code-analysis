package com.gaopal.pattern.adapter.demo.passport.adapterv2.adapters;

import com.gaopal.pattern.adapter.demo.passport.ResultMsg;

public interface ILoginAdapter {
  boolean support(Object object);

  ResultMsg login(String id, Object adapter);
}
