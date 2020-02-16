package com.light.event;

import com.light.obj.BaseObj;
import com.light.scene.BaseScene;

import java.util.HashSet;
import java.util.Set;

public  abstract class AbstractEventOp<T extends BaseObj> implements EventOp<T> {
    protected Set<T> set;
    protected BaseScene baseScene;
    public AbstractEventOp() {
        this.set = new HashSet<>();
    }

    @Override
    public Set<T> getObjs() {
        return set;
    }

    public BaseScene getBaseSe() {
        return baseScene;
    }

    @Override
    public void setBaseSe(BaseScene baseScene) {
        this.baseScene = baseScene;
    }

    @Override
    public void addObj(T t) {
        set.add(t);
        if (t.getFxEventOps().contains(this))
            return;
        t.addEventOp(this);
    }
}
