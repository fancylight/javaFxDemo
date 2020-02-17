package com.light.tank.obj;


import com.light.base.Position;
import com.light.obj.AbstractBaseObj;
import javafx.scene.image.Image;

public abstract class Wall extends AbstractBaseObj {

    boolean cross;


    public Wall(Image image, Position position) {
        super(image, position);
    }
}
