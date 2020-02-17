package com.light.tank.TankApp;

import com.light.base.manager.SceneCreator;
import com.light.scene.BaseScene;
import com.light.tank.event.TankEvent;
import com.light.tank.obj.Tank;
import com.light.tank.obj.TankFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class TankCreate extends SceneCreator {

    @Override
    protected List<BaseScene> createScenesRe() {
        BaseScene baseScene = new BaseScene(600, 800, "init");
        List<BaseScene> list = new ArrayList<>();
        list.add(baseScene);
        Tank tank = new TankFactory().getInitTank(1);
        Tank tank2 = new TankFactory().getInitTank(2);
        TankEvent tankEvent = new TankEvent();
        tank.addEventOp(tankEvent);
        tank2.addEventOp(tankEvent);
        baseScene.addBaseObj(tank);
        baseScene.addBaseObj(tank2);
        return list;
    }
}
