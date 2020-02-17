package com.light.tank.event;

import com.light.LaunchApp;
import com.light.event.AbstractFxEventOp;
import javafx.scene.input.KeyEvent;

public class ChangeEvent extends AbstractFxEventOp {
    @Override
    protected void initEventMap() {
        addHandler("KeyPressed", event -> {
            KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.getCode().getChar().equals("C"))
                LaunchApp.sceneManager.changeCurrentScene("test");
        });
    }
}
