package org.study.spring5.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.study.spring5.aop.annotation.Audited;

@Component
public class AuditBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        final Audited audited = AnnotationUtils.findAnnotation(bean.getClass(), Audited.class);
        if (AnnotationHelper.hasAnnotation(bean, Audited.class)) {
            ProxyFactory factory = new ProxyFactory();
            factory.setTarget(bean);
            factory.addAdvice(new AuditLogInterceptor());
            return factory.getProxy();
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
