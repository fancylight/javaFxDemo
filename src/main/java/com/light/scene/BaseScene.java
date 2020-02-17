package com.light.scene;

import com.light.annotaion.SceneOrder;
import com.light.event.CustomEventOp;
import com.light.event.EventOp;
import com.light.event.FxEventOp;
import com.light.obj.BaseObj;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@SceneOrder(1)
public class BaseScene extends Canvas {
    private Map<String, Method> fxEventMap;
    private Set<EventOp> eventOps;
    private Set<BaseObj> set;
    private int duration = 10;
    private KeyFrame keyFrame;
    private Timeline timeline;
    private String name;
    protected Scene parentScene;
    private Group group;
    private static Logger logger = LogManager.getLogger(BaseScene.class);
    private boolean palying = false;

    //
    public BaseScene(int width, int height, String name) {
        super(width, height);
        Group group = new Group();
        group.getChildren().add(this);
        parentScene = new Scene(group, width, height);
        this.set = new HashSet<>();
        this.eventOps = new HashSet<>();
        this.name = name;
        init();
    }

    public void play() {
        timeline.play();
    }

    public void pause() {
        timeline.stop();
    }

    public void addEventOp(EventOp eventOp) {
        set.addAll(eventOp.getObjs());
        updateEvent(eventOp);
    }

    public void addBaseObj(BaseObj baseObj) {
        set.add(baseObj);
        baseObj.getFxEventOps().forEach(this::updateEvent);
    }

    public void removeBaseObj(BaseObj baseObj) {
        set.remove(baseObj);
    }


    /**
     * 添加事件
     *
     * @param eventOp
     */
    private void updateEvent(EventOp eventOp) {
        eventOps.add(eventOp);
        eventOp.setBaseSe(this);
        if (eventOp instanceof CustomEventOp) {
            eventOps.add(eventOp);
        } else if (eventOp instanceof FxEventOp) {
            FxEventOp fxEventOp = (FxEventOp) eventOp;
            Map<String, EventHandler> handlerMap = fxEventOp.getFxEvents();
            handlerMap.forEach((t, u) -> {
                Method method = fxEventMap.get(t.toUpperCase());
                if (method != null) {
                    try {
                        method.invoke(parentScene, u);
                    } catch (IllegalAccessException e) {
                        logger.error(e.getMessage());
                    } catch (InvocationTargetException e) {
                        logger.error(e.getMessage());
                    }
                } else {
                    logger.error("未能正确注册" + t + u.getClass());
                }
            });
        }
    }

    private void init() {
        //[1]初始化fx事件缓存
        initFxEvent();
        //[2]处理渲染逻辑
        dealDraw();
    }

    private void dealDraw() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        keyFrame = new KeyFrame(new Duration(duration), (event) -> {
            fireRule();
            drawObj();
        });
        timeline.getKeyFrames().add(keyFrame);
    }

    /**
     * 渲染元素
     */
    private void drawObj() {
        getGraphicsContext2D().clearRect(0, 0, this.getWidth(), this.getHeight());
        set.stream().forEach(obj -> obj.draw(getGraphicsContext2D()));
    }

    /**
     * 执行非事件逻辑
     */
    private void fireRule() {
        eventOps.stream().filter((eventOp -> eventOp instanceof CustomEventOp))
                .forEach(eventOp -> ((CustomEventOp) (eventOp)).changeByRule(set));
    }

    /**
     * 初始fx事件缓存
     */
    private void initFxEvent() {
        if (fxEventMap == null)
            fxEventMap = new HashMap<>();
        Stream.of(Scene.class.getDeclaredMethods()).filter(method -> method.getName().contains("setOn")).forEach(method -> {
            fxEventMap.put(method.getName().substring(5).toUpperCase(), method);
        });
    }

    /**
     * 当场景切换时,执行逻辑
     */
    public void onChange() {
        if (!palying) {
            play();
            palying = true;
        } else {
            pause();
            palying = false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scene getParentScene() {
        return parentScene;
    }
}
