package com.gaopal.pattern.command.player.actions;

import com.gaopal.pattern.command.player.GPlayer;
import com.gaopal.pattern.command.player.IAction;

public class StopAction implements IAction {
  private GPlayer gplayer;

  public StopAction(GPlayer gplayer) {
    this.gplayer = gplayer;
  }

  public void execute() {
    gplayer.stop();
  }
}
