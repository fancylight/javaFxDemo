package com.light.event;

import com.light.LaunchApp;
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
