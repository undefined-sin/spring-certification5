package org.study.spring5.container.customizing;

import org.springframework.context.LifecycleProcessor;

public class LifecycleProcessorBean extends LifecycleListener implements LifecycleProcessor {

    @Override
    public void onRefresh() {
        log("onRefresh: " + this.getName());
    }

    @Override
    public void onClose() {
        log("onClose: " + this.getName());
    }


}
