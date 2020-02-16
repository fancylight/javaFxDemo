package com.light.event;

import com.light.obj.BaseObj;
import javafx.event.EventHandler;

import java.util.Map;

public interface FxEventOp<T extends BaseObj> extends EventOp<T> {
    Map<String, EventHandler> getFxEvents();
    void addHandler(String event,EventHandler eventHandler);

}
