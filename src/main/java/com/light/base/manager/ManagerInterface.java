package com.light.base.manager;


import com.light.scene.BaseScene;

import java.util.List;

/**
 * 该接口表示管理场景,所有的场景即{@link BaseScene},实现了单一场景的循环渲染逻辑
 */
public interface ManagerInterface {
    List<BaseScene> getAllScene();

    void setScene(BaseScene BaseScene);

    BaseScene getScene(String name);

    void changeCurrentScene(String sceneName);

    void addScenes(List<BaseScene> scenes);

    BaseScene getCurrentScene();
}
