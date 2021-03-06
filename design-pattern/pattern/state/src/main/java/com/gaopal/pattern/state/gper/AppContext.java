package com.gaopal.pattern.state.gper;

public class AppContext {

  public static final UserState STATE_LOGIN = new LoginState();
  public static final UserState STATE_UNLOGIN = new UnLoginState();

  private UserState currentState = STATE_UNLOGIN;

  {
    STATE_LOGIN.setContext(this);
    STATE_UNLOGIN.setContext(this);
  }

  public UserState getState() {
    return this.currentState;
  }

  public void setState(UserState state) {
    this.currentState = state;
  }

  public void favorite() {
    this.currentState.favorite();
  }

  public void comment(String comment) {
    this.currentState.comment(comment);
  }
}
