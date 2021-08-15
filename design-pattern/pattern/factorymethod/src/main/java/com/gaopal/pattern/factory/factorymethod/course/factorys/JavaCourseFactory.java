package com.gaopal.pattern.factory.factorymethod.course.factorys;

import com.gaopal.pattern.factory.factorymethod.course.products.ICourse;
import com.gaopal.pattern.factory.factorymethod.course.products.JavaCourse;


public class JavaCourseFactory implements ICourseFactory {
  public ICourse create() {
    return new JavaCourse();
  }
}
