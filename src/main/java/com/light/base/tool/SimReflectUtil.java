package com.light.base.tool;

import java.lang.annotation.Annotation;

public class SimReflectUtil {
    public static<T extends Annotation> T getAn(Object o, Class<T> tClass) {
        return o.getClass().getAnnotation(tClass);
    }
}
