package com.light.tank.obj;

import com.light.base.Position;
import javafx.scene.image.Image;

import java.io.File;

public class TankFactory {
    public static final String p1_up = "00000000";
    public static final String p1_right = "00000001";
    public static final String p1_down = "00000010";
    public static final String p1_left = "00000011";
    public static final String p2_up = "00000100";
    public static final String p2_right = "00001001";
    public static final String p2_down = "00000110";
    public static final String p2_left = "00000111";
    public static final String basePath = File.separator+"base";
    public static final String imgSuffix = ".gif";
    public static final int widthInit=30;
    public static final int heightInit=30;
    /**
     * 00 0000 00
     * 坦克 方向
     *
     * @param number
     * @return
     */
    public Tank getInitTank(int number) {
        Tank tank = null;
       if (number == 1) {
           tank = new Tank(Tank.Tank_1,createTankImage(p1_up),new Position(50,50,widthInit,heightInit));
       } else if (number ==2) {
           tank = new Tank(Tank.Tank_2,createTankImage(p2_up),new Position(100,50,widthInit,heightInit));
       }
           return tank;
    }

    public Image createTankImage(String direction) {
        return new Image(basePath+File.separator+direction+imgSuffix);
    }
}
