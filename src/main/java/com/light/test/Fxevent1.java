package com.light.test;

import com.light.event.AbstractFxEventOp;

public class Fxevent1 extends AbstractFxEventOp<Obj1> {

    @Override
    protected void initEventMap() {
        addHandler("KeyPressed",(event)-> System.out.println(123));
    }


}
