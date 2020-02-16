package com.light.tank.resource;
import javafx.scene.image.Image;

import java.io.InputStream;

public class ImageOp {
    public static   Image  getImage(String path) {
        InputStream inputStream = ImageOp.class.getResourceAsStream(path);
        return new Image(inputStream);
    }
}
