package com.gaopal.pattern.factory.abstractfactory.course.factorys;

import com.gaopal.pattern.factory.abstractfactory.course.products.INote;
import com.gaopal.pattern.factory.abstractfactory.course.products.IVideo;
import com.gaopal.pattern.factory.abstractfactory.course.products.PythonNote;
import com.gaopal.pattern.factory.abstractfactory.course.products.PythonVideo;


public class PythonCourseFactory extends CourseFactory {

  public INote createNote() {
    super.init();
    return new PythonNote();
  }

  public IVideo createVideo() {
    super.init();
    return new PythonVideo();
  }
}
