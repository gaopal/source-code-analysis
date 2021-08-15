package com.gaopal.pattern.command.player;

import com.gaopal.pattern.command.player.actions.PauseAction;
import com.gaopal.pattern.command.player.actions.PlayAction;
import com.gaopal.pattern.command.player.actions.SpeedAction;
import com.gaopal.pattern.command.player.actions.StopAction;

public class Test {
  public static void main(String[] args) {

    GPlayer player = new GPlayer();
    Controller controller = new Controller();
    controller.execute(new PlayAction(player));

    controller.addAction(new PauseAction(player));
    controller.addAction(new PlayAction(player));
    controller.addAction(new StopAction(player));
    controller.addAction(new SpeedAction(player));
    controller.executes();
  }
}
