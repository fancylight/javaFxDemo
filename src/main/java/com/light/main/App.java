package com.light.main;

import com.light.common.Constant;
import com.light.scene.BaseScene;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class App extends Application {
    public static int width = Constant.blockLength*Constant.sceneBlockWidth;
    public static int height = Constant.blockLength*Constant.sceneBlockWeight;

    private Group group = new Group();
    private Scene scene = new Scene(group,width,height);
    private Stage  stage;
    public static BaseScene currentBaseScene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        BaseScene baseScene = new BaseScene(width,height,scene);
        currentBaseScene=baseScene;
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
