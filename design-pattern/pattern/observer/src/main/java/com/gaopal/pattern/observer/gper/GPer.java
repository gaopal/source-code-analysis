package com.gaopal.pattern.observer.gper;

import java.util.Observable;

public class GPer extends Observable {
  private static final GPer gper = new GPer();
  private String name = "GPer生态圈";

  private GPer() {}

  public static GPer getInstance() {
    return gper;
  }

  public String getName() {
    return name;
  }

  public void publishQuestion(Question question) {
    System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
    setChanged();
    notifyObservers(question);
  }
}
