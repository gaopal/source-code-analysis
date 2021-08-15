package com.gaopal.pattern.observer.mouseevent;

import com.gaopal.pattern.observer.mouseevent.core.EventListener;
import com.gaopal.pattern.observer.mouseevent.handler.Mouse;
import com.gaopal.pattern.observer.mouseevent.handler.MouseEventListener;
import com.gaopal.pattern.observer.mouseevent.handler.MouseEventType;

public class Test {
  public static void main(String[] args) {
    EventListener listener = new MouseEventListener();

    Mouse mouse = new Mouse();
    mouse.addListener(MouseEventType.ON_CLICK, listener);
    mouse.addListener(MouseEventType.ON_MOVE, listener);

    mouse.click();
    mouse.move();
  }
}
