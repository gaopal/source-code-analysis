package com.gaopal.pattern.mediator.rpc;

public class AService implements IService {
  Registy registy;

  AService() {
    registy.regist("aService", this);
  }

  public void a() {
    // registy.get("bService").xxx();
  }
}
