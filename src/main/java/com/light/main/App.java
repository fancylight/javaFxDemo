package com.light.main;

import com.light.scene.BaseScene;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class App extends Application {
    public static int width =600;
    public static int height =800;

    private Group group = new Group();
    private Scene scene = new Scene(group,width,height);
    private Stage  stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        BaseScene baseScene = new BaseScene(width,height,scene);
        initEventAndObj(baseScene);
        group.getChildren().add(baseScene);
        primaryStage.setScene(scene);
        primaryStage.show();
        baseScene.play();
    }

    public void changeScene(Scene scene) {
        //:todo 以后再说
    }
    /**
     * 初始化
     * @param baseScene
     */
    protected abstract void initEventAndObj(BaseScene baseScene) ;
}
