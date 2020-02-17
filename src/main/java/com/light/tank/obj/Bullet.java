package com.light.tank.obj;

import com.light.base.Position;
import com.light.main.App;
import com.light.obj.AbstractBaseObj;
import com.light.tank.TankApp.AppTank;
import javafx.scene.image.Image;

import java.util.Timer;
import java.util.TimerTask;

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
                double change= position.getY() - 2*AppTank.minUnit;
                if (change >=0) {
                    position.setY(change);
                }
                isDestory();

            }
        },0,10);
    }

    //判断碰撞
    private void isDestory(){
        //碰撞清除


        //边界清除
        if(this.position.getY()==0){
            App.currentBaseScene.removeBaseObj(this);
        }

    }

}
