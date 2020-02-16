package com.light.obj;

import com.light.base.Position;
import com.light.event.EventOp;
import javafx.scene.canvas.GraphicsContext;

import java.util.Set;

public interface BaseObj {
    int getId();

    Set<EventOp> getFxEventOps();

    void addEventOp(EventOp fxEventOp);

    void draw(GraphicsContext gc);

    void setEffective(boolean bool);

    boolean getEffective();

    Position getPos();
}
