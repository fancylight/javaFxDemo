package com.light.tank.obj;

import com.light.LaunchApp;
import com.light.base.Position;
import com.light.obj.AbstractBaseObj;
import javafx.scene.image.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.light.tank.Constant.*;

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
        double change= this.position.getX()- MINUNIT;
        if(!turn(TankFactory.p1_left)){
            return;
        }
        if (change >=0 && change <= APPWIDTH ) {
            this.position.setX(change);
        }
    }
    public void right() {
        double change= this.position.getX() + MINUNIT;
        if(!turn(TankFactory.p1_right)){
            return;
        }
        if (change >=0 && change <= (APPWIDTH-this.position.getWidth()) ) {
            this.position.setX(change);
        }
    }
    public void up() {
        double change= this.position.getY() - MINUNIT;
        if(!turn(TankFactory.p1_up)){
            return;
        }
        if (change >=0 && change <= APPHEIGHT ) {
            this.position.setY(change);
        }
    }
    public void down() {
        double change= this.position.getY() + MINUNIT;
        if(!turn(TankFactory.p1_down)){
            return;
        }
        if (change >=0 && change <=( APPHEIGHT-this.getPosition().getHeight()) ) {
            this.position.setY(change);
        }
    }
    public void fire() {
        double x = this.position.getX()+10;
        double y = this.position.getY();
        Bullet bullet = new Bullet(new TankFactory().createTankImage(TankFactory.p2_up), new Position(x, y, 10, 10), "up");
        LaunchApp.sceneManager.getCurrentScene().addBaseObj(bullet);
        bullet.go();
    }


    //转向
    private boolean turn(String direction){
        String currentUrl = this.getImage().getUrl();
        Image image = new TankFactory().createTankImage(direction);
        String newUrl = image.getUrl();
        this.setImage(image);
        if(currentUrl.equals(newUrl)){
            return true;
        }
        return false;
    }


}
