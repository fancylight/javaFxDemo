package com.light.event;

import com.light.obj.BaseObj;
import javafx.event.EventHandler;


import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFxEventOp<T extends BaseObj> extends AbstractEventOp<T> implements FxEventOp<T> {
    private Map<String, EventHandler> eventHandlerMap;
    public AbstractFxEventOp() {
        this.eventHandlerMap = new HashMap<>();
        initEventMap();
    }

    /**
     * 由子类调用初始化该类时添加事件逻辑到map中
     */
    protected abstract void initEventMap();

    @Override
    public Map<String, EventHandler> getFxEvents() {
        return eventHandlerMap;
    }
    @Override
    public void addHandler(String event, EventHandler eventHandler) {
        eventHandlerMap.put(event,eventHandler);
    }


}
