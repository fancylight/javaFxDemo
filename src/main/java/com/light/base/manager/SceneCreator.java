package com.light.base.manager;

import com.light.scene.BaseScene;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 场景初始化,由子类实现,返回初始化的场景
 */
@Configuration
public abstract class SceneCreator {
    @Bean("scenes")
    public List<BaseScene> createScenes() {
        return createScenesRe();
    }

    protected abstract List<BaseScene> createScenesRe();
}
