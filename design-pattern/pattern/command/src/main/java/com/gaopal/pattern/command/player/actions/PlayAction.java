package com.gaopal.pattern.command.player.actions;

import com.gaopal.pattern.command.player.GPlayer;
import com.gaopal.pattern.command.player.IAction;

public class PlayAction implements IAction {
  private GPlayer gplayer;

  public PlayAction(GPlayer gplayer) {
    this.gplayer = gplayer;
  }

  public void execute() {
    gplayer.play();
  }
}
