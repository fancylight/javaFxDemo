package com.light.tank.TankApp;

import com.light.main.App;
import com.light.scene.BaseScene;
import com.light.tank.event.TankEvent;
import com.light.tank.obj.Tank;
import com.light.tank.obj.TankFactory;

public class AppTank extends App {
    public static int minUnit=3;
    @Override
    protected void initEventAndObj(BaseScene baseScene) {
        Tank tank = new TankFactory().getInitTank(1);
        Tank tank2 = new TankFactory().getInitTank(2);
        TankEvent tankEvent = new TankEvent();
        tank.addEventOp(tankEvent);
        tank2.addEventOp(tankEvent);
        baseScene.addBaseObj(tank);
        baseScene.addBaseObj(tank2);
    }
}
