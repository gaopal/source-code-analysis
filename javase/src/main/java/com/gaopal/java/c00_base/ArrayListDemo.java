package com.gaopal.java.c00_base;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ArrayListDemo {

  @Test
  public void initByCollection() {
    List<String> list = Arrays.asList("Hello,world");
    Object[] objArray = list.toArray();
    log.info(objArray.getClass().getSimpleName());
    // objArray 元素的类型是String, 存储Object就会报错,因为jvm不清楚存储的
    // Object真实类型是不是String
    // 该问题在Java9中被解决 https://bugs.java.com/bugdatabase/viewbug.do?bugid=6260652
    // OpenJDK中意解决该问题
    objArray[0] = new Object();
  }

}
