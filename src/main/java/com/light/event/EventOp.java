package com.light.event;

import com.light.obj.BaseObj;
import com.light.scene.BaseScene;

import java.util.Set;

public interface EventOp<T extends BaseObj> {
    Set<T> getObjs();
    void addObj(T t);
    BaseScene getBaseSe();

    void setBaseSe(BaseScene baseScene);
}
