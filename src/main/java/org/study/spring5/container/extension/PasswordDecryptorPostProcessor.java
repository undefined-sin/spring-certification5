package org.study.spring5.container.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import org.study.spring5.StudyBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

public class PasswordDecryptorPostProcessor extends StudyBean implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log("postProcessBeforeInitialization bean: " + bean.getClass().getName());
        if (bean instanceof Credentials) {
            Method get = ReflectionUtils.findMethod(bean.getClass(), "getSecret");
            String secret = invokeGracefully(bean, get);
            log("Decrypt candidate found with secret: %s", secret);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log("postProcessAfterInitialization bean: " + bean.getClass().getName());
        if (bean instanceof Credentials) {
            Method set = ReflectionUtils.findMethod(bean.getClass(), "setPassword", char[].class);
            Method get = ReflectionUtils.findMethod(bean.getClass(), "getSecret");
            String key = invokeGracefully(bean, get);
            key = Credentials.normalizeString(key);
            byte[] decoded = Base64.getDecoder().decode(key);
            setGracefully(bean, set, convertByteArrToChar(decoded));
        }
        return bean;
    }


    private void setGracefully(Object bean, Method set, Object... args) {
        try {
            set.invoke(bean, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private char[] convertByteArrToChar(byte[] decoded) {
        return new String(decoded).toCharArray();
    }

    private <T> T invokeGracefully(Object bean, Method get, Object... args) {
        try {
            return (T) get.invoke(bean, args);
        } catch (IllegalAccessException | InvocationTargetException | ClassCastException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Could not call method" + get.getName());
    }

}
