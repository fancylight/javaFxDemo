package com.light;

import com.light.base.manager.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaunchApp extends Application {
    public static SpringApplication springApplication;
    private ApplicationContext context;
    public static SceneManager sceneManager;

    public static void main(String[] args) {
        launch(LaunchApp.class, args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        springApplication = new SpringApplication(this.getClass());
        context = springApplication.run(LaunchApp.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        sceneManager = context.getBean("sceneManager", SceneManager.class);
        sceneManager.setStage(primaryStage);
        sceneManager.changeCurrentScene("init");
        primaryStage.show();
    }
}
