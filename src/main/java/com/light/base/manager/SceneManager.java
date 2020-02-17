package com.light.base.manager;

import com.light.annotaion.SceneOrder;
import com.light.base.tool.SimReflectUtil;
import com.light.scene.BaseScene;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 该实现类可以通过{@link com.light.LaunchApp#sceneManager} 进行访问
 * 该类实现了对于任意场景的切换
 */
@Component("sceneManager")
public class SceneManager implements ManagerInterface, ApplicationContextAware {
    private Scene currentStage;
    private Stage stage;
    private Map<String, BaseScene> sceneMap = new HashMap<>();
    private List<BaseScene> list;
    private ApplicationContext applicationContext;
    private BaseScene currentBaseScene;

    public SceneManager(@Qualifier("scenes") List<BaseScene> list) {
        this.list = list;
        list.sort((t1, t2) -> {
            int order1 = SimReflectUtil.getAn(t1, SceneOrder.class).value();
            int order2 = SimReflectUtil.getAn(t1, SceneOrder.class).value();
            return order1 >= order2 ? 1 : -1;
        });
        list.forEach(ele -> sceneMap.put(ele.getName(), ele));
    }

    @Override
    public List<BaseScene> getAllScene() {
        return sceneMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void setScene(BaseScene BaseScene) {
        sceneMap.put(BaseScene.getName(), BaseScene);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public BaseScene getScene(String name) {
        BaseScene scene = Optional.of(sceneMap.get(name)).get();
        return scene;
    }

    /**
     * 切换场景
     *
     * @param sceneName 场景名
     */
    @Override
    public void changeCurrentScene(String sceneName) {
        BaseScene baseScene = Optional.ofNullable(sceneMap.get(sceneName)).get();
        //场景切换
        if (currentBaseScene != null)
        currentBaseScene.onChange();
        baseScene.onChange();
        Scene scene = baseScene.getParentScene();
        if (scene != currentStage) {
            stage.setScene(scene);
            currentStage = scene;
            currentBaseScene = baseScene;
        }
    }

    @Override
    public void addScenes(List<BaseScene> scenes) {
        scenes.forEach((scene) -> sceneMap.put(scene.getName(), scene));
    }

    @Override
    public BaseScene getCurrentScene() {
        return currentBaseScene;
    }

    /**
     * 获取spring中所有的场景
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//        Map<String, BaseScene> BaseSceneMap = applicationContext.getBeansOfType(BaseScene.class);

    }
}
