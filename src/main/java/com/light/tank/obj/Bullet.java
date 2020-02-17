package com.light.tank.obj;

import com.light.LaunchApp;
import com.light.base.Position;
import com.light.obj.AbstractBaseObj;
import javafx.scene.image.Image;

import java.util.Timer;
import java.util.TimerTask;

import static com.light.tank.Constant.MINUNIT;

public class Bullet extends AbstractBaseObj {

    private String direction;

    public Bullet(Image image, Position position,String direction) {
        super(image, position);
        this.direction=direction;
    }


    public void go(){
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                double change= position.getY() - 2*MINUNIT;
                if (change >=0) {
                    position.setY(change);
                }

            }
        },0,10);
    }

}
