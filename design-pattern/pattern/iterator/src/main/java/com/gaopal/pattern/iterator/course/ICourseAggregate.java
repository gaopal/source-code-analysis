package com.gaopal.pattern.iterator.course;

public interface ICourseAggregate {
  void add(Course course);

  void remove(Course course);

  Iterator<Course> iterator();
}
