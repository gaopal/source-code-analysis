package com.gaopal.pattern.composite.demo.transparent;


public class Course extends CourseComponet {

  private String name;
  private double price;

  public Course(String name, double price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String getName(CourseComponet componet) {
    return this.name;
  }

  @Override
  public double getPrice(CourseComponet componet) {
    return this.price;
  }

  @Override
  public void print() {
    System.out.println(name + "(￥" + price + "元)");
  }
}
