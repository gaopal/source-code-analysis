package com.gaopal.pattern.bridge.message;

public class UrgencyMessage extends AbastractMessage {
  public UrgencyMessage(IMessage message) {
    super(message);
  }

  void sendMessage(String message, String toUser) {
    message = "【加急】" + message;
    super.sendMessage(message, toUser);
  }

  public Object watch(String messageId) {
    return null;
  }
}
