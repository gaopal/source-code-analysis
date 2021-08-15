package com.gaopal.pattern.mediator.rpc;

public class BService implements IService {
  Registy registy;

  BService() {
    registy.regist("bService", this);
  }
}
