package com.gaopal.pattern.factory.factorymethod.course;

import com.gaopal.pattern.factory.factorymethod.course.factorys.ICourseFactory;
import com.gaopal.pattern.factory.factorymethod.course.factorys.JavaCourseFactory;
import com.gaopal.pattern.factory.factorymethod.course.factorys.PythonCourseFactory;
import com.gaopal.pattern.factory.factorymethod.course.products.ICourse;


public class Test {

  public static void main(String[] args) {

    ICourseFactory factory = new PythonCourseFactory();
    ICourse course = factory.create();
    course.record();

    factory = new JavaCourseFactory();
    course = factory.create();
    course.record();
  }
}
