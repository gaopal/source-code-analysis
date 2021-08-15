package com.gaopal.pattern.factory.abstractfactory.course;

import com.gaopal.pattern.factory.abstractfactory.course.factorys.JavaCourseFactory;


public class Test {

  public static void main(String[] args) {

    JavaCourseFactory factory = new JavaCourseFactory();

    factory.createNote().edit();
    factory.createVideo().record();
  }
}
