package org.study.spring5.container.dependencies;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SimpleCommandManager extends CommandManager implements ApplicationContextAware {

    private ApplicationContext appContext;

    // This is not desirable because business code is aware of ApplicationContext.
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.appContext = ctx;
    }

    protected DispatcherSource getDispatcherSource() {
        return appContext.getBean(DispatcherSource.class);
    }

}
