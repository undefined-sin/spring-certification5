package org.study.spring5.aop;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationHelper {
    public static <A extends Annotation> boolean hasAnnotation(Object bean, Class<A> annotationType) {
        A a = AnnotationUtils.findAnnotation(bean.getClass(), annotationType);
        if (a != null) {
            return true;
        }
        Method[] methods = bean.getClass().getDeclaredMethods();
        return Arrays
                .stream(methods)
                .anyMatch(m -> AnnotationUtils.findAnnotation(m, annotationType) != null);
    }

}
