package com.gaopal.pattern.factory.factorymethod.course.factorys;

import com.gaopal.pattern.factory.factorymethod.course.products.ICourse;
import com.gaopal.pattern.factory.factorymethod.course.products.PythonCourse;


public class PythonCourseFactory implements ICourseFactory {

  public ICourse create() {
    return new PythonCourse();
  }
}
