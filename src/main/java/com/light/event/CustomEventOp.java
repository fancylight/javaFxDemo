package com.light.event;

import com.light.obj.BaseObj;

import java.util.Set;

public interface CustomEventOp<T extends BaseObj> extends EventOp<T> {
    void changeByRule(Set<T> objSet);
}
