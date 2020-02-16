package com.light.test;

import com.light.main.App;
import com.light.scene.BaseScene;

public class TestApp extends App {
    @Override
    protected void initEventAndObj(BaseScene baseScene) {
        Fxevent1 fxevent1 = new Fxevent1();
        baseScene.addEventOp(fxevent1);
    }
}
