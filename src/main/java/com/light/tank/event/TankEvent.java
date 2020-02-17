package com.light.tank.event;

import com.light.event.AbstractFxEventOp;
import com.light.tank.obj.Tank;
import javafx.scene.input.KeyEvent;

public class TankEvent extends AbstractFxEventOp<Tank> {
    private Tank tank_p1;
    private Tank tank_p2;
    private boolean flag = false;
    private boolean initTank() {
        getObjs().stream().forEach(tank -> {
            if (tank.getTankId().endsWith(Tank.Tank_1)) {
                tank_p1 = tank;
            } else if (tank.getTankId().endsWith(Tank.Tank_2)) {
                tank_p2 = tank;
            }
        });
        return tank_p1!=null || tank_p2 !=null ;
    }
    @Override
    protected void initEventMap() {
        addHandler("KeyPressed",event -> {
            if (!flag) {
                flag =initTank();
            }
            KeyEvent keyEvent = (KeyEvent) event;
           switch (keyEvent.getCode().getChar()) {
               case "A": {
                   tank_p1.left();
                   break;
               }
               case "W" : {
                   tank_p1.up();
                   break;
               }
               case "D" : {
                   tank_p1.right();
                   break;
               }
               case "S" : {
                   tank_p1.down();
                   break;
               }
               case "J" : {
                   tank_p1.fire();
                   break;
               }
           }
        });
    }
}
