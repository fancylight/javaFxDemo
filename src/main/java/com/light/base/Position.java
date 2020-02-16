package com.light.base;

import javafx.beans.property.DoublePropertyBase;
import javafx.beans.property.SimpleDoubleProperty;

public class Position {

    public DoublePropertyBase x =new SimpleDoubleProperty();
    public DoublePropertyBase y =new SimpleDoubleProperty();
    public DoublePropertyBase width =new SimpleDoubleProperty();
    public DoublePropertyBase height =new SimpleDoubleProperty();

    public Position(double x, double y,double width,double height) {
        this.x.set(x);
        this.y.set(y);
        this.width.set(width);
        this.height.set(height);
    }

    public double getX() {
        return x.get();
    }

    public DoublePropertyBase xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public DoublePropertyBase yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public double getWidth() {
        return width.get();
    }

    public DoublePropertyBase widthProperty() {
        return width;
    }

    public void setWidth(double width) {
        this.width.set(width);
    }

    public double getHeight() {
        return height.get();
    }

    public DoublePropertyBase heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
