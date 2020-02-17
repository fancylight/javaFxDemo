package com.light.obj;

import com.light.base.Position;
import com.light.common.Constant;
import com.light.event.EventOp;
import com.light.scene.BaseScene;
import javafx.scene.canvas.GraphicsContext;

import java.util.Set;

public interface BaseObj {

    int blockWidth= Constant.blockLength;

    int blockWeight= Constant.blockLength;

    int getId();


    Set<EventOp> getFxEventOps();

    void addEventOp(EventOp fxEventOp);

    void draw(GraphicsContext gc);

    void setEffective(boolean bool);

    boolean getEffective();

    Position getPos();
}
