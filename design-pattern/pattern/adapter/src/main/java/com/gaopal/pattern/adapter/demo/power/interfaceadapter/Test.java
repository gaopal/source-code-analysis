package com.gaopal.pattern.adapter.demo.power.interfaceadapter;

public class Test {
  public static void main(String[] args) {
    DC adapter = new PowerAdapter(new AC220());
    adapter.output5V();
  }
}
