package com.gaopal.pattern.mediator.rpc;

public class CService implements IService {
  Registy registy;

  CService() {
    registy.regist("cService", this);
  }
}
