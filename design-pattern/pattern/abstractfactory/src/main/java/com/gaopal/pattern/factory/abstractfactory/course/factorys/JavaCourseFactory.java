package com.gaopal.pattern.factory.abstractfactory.course.factorys;

import com.gaopal.pattern.factory.abstractfactory.course.products.INote;
import com.gaopal.pattern.factory.abstractfactory.course.products.IVideo;
import com.gaopal.pattern.factory.abstractfactory.course.products.JavaNote;
import com.gaopal.pattern.factory.abstractfactory.course.products.JavaVideo;


public class JavaCourseFactory extends CourseFactory {

  public INote createNote() {
    super.init();
    return new JavaNote();
  }

  public IVideo createVideo() {
    super.init();
    return new JavaVideo();
  }
}
