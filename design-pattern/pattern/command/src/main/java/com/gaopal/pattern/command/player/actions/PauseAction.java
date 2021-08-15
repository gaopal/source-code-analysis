package com.gaopal.pattern.command.player.actions;

import com.gaopal.pattern.command.player.GPlayer;
import com.gaopal.pattern.command.player.IAction;

public class PauseAction implements IAction {
  private GPlayer gplayer;

  public PauseAction(GPlayer gplayer) {
    this.gplayer = gplayer;
  }

  public void execute() {
    gplayer.pause();
  }
}
