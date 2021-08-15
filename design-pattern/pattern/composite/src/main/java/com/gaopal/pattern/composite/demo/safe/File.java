package com.gaopal.pattern.composite.demo.safe;


public class File extends Direcotry {
  public File(String name) {
    super(name);
  }

  public void show() {
    System.out.println(this.name);
  }
}
