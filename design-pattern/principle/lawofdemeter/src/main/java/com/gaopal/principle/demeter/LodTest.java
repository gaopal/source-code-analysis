package com.gaopal.principle.demeter;

/** Created by gaopal on 2020/2/16. */
public class LodTest {

  public static void main(String[] args) {
    TeamLeader teamLeader = new TeamLeader();
    Employee employee = new Employee();
    teamLeader.commandCheckNumber(employee);
  }
}
