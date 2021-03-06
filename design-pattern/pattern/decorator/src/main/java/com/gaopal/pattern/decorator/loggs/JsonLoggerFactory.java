package com.gaopal.pattern.decorator.loggs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JsonLoggerFactory {

  public static JsonLogger getLogger(Class clazz) {
    Logger logger = LoggerFactory.getLogger(clazz);
    return new JsonLogger(logger);
  }
}
