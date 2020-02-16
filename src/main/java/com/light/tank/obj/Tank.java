package com.light.tank.obj;

import com.light.base.Position;
import com.light.main.App;
import com.light.obj.AbstractBaseObj;
import com.light.tank.TankApp.AppTank;
import javafx.scene.image.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tank extends AbstractBaseObj {
    public static final String Tank_1="TANK_P1";
    public static final String Tank_2="TANK_P2";
    private static Logger logger = LogManager.getLogger(Tank.class);
    private String tankId;
    public Tank(String number,Image image, Position position) {
        super(image, position);
        this.tankId = number;
    }

    public String getTankId() {
        return tankId;
    }

    public void setTankId(String tankId) {
        this.tankId = tankId;
    }

    public void left() {
        double change= this.position.getX()- AppTank.minUnit;
        if (change >=0 && change <= App.width ) {
            Image image = new TankFactory().createTankImage(TankFactory.p1_left);
            this.setImage(image);
            this.position.setX(change);
        }
    }
    public void right() {
        double change= this.position.getX() + AppTank.minUnit;
        if (change >=0 && change <= (App.width-this.position.getWidth()) ) {
            Image image = new TankFactory().createTankImage(TankFactory.p1_right);
            this.setImage(image);
            this.position.setX(change);
        }
    }
    public void up() {
        double change= this.position.getY() - AppTank.minUnit;
        if (change >=0 && change <= App.height ) {
            Image image = new TankFactory().createTankImage(TankFactory.p1_up);
            this.setImage(image);
            this.position.setY(change);
        }
    }
    public void down() {
        double change= this.position.getY() + AppTank.minUnit;
        if (change >=0 && change <=( App.height-this.getPosition().getHeight()) ) {
            Image image = new TankFactory().createTankImage(TankFactory.p1_down);
            this.setImage(image);
            this.position.setY(change);
        }
    }
    public void fire() {

    }

}
