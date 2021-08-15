package com.gaopal.pattern.command.player.actions;

import com.gaopal.pattern.command.player.GPlayer;
import com.gaopal.pattern.command.player.IAction;

public class SpeedAction implements IAction {
  private GPlayer gplayer;

  public SpeedAction(GPlayer gplayer) {
    this.gplayer = gplayer;
  }

  public void execute() {
    gplayer.speed();
  }
}
