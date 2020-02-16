package com.light.obj;

import com.light.base.Position;
import com.light.event.EventOp;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractBaseObj implements BaseObj {
    private Set<EventOp> eventOps;
    private Image image;
    private static Logger logger = LogManager.getLogger(AbstractBaseObj.class);
    protected BooleanProperty visibleProperty = new SimpleBooleanProperty(true);
    protected Position position;
    public AbstractBaseObj(Image image, Position position) {
        this.eventOps = new HashSet<>();
        this.image = image;
        this.position = position;
    }

    public int getId() {
        return hashCode();
    }
    @Override
    public Set<EventOp> getFxEventOps() {
        return eventOps;
    }

    @Override
    public Position getPos() {
        return position;
    }

    @Override
    public void addEventOp(EventOp eventOp) {
        eventOps.add(eventOp);
        if (eventOp.getObjs().contains(this))
            return;
        eventOp.addObj(this);
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (!visibleProperty.get())
            return;
        logger.info(this.position);
        gc.drawImage(image,position.getX(),position.getY(),position.getWidth(),position.getHeight());
    }

    @Override
    public void setEffective(boolean bool) {
        visibleProperty.set(bool);
    }

    @Override
    public boolean getEffective() {
        return visibleProperty.get();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isVisibleProperty() {
        return visibleProperty.get();
    }

    public BooleanProperty visiblePropertyProperty() {
        return visibleProperty;
    }

    public void setVisibleProperty(boolean visibleProperty) {
        this.visibleProperty.set(visibleProperty);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
