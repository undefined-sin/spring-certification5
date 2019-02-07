package org.study.spring5.container.customizing;

import org.springframework.context.Lifecycle;
import org.study.spring5.StudyBean;

public class LifecycleListener extends StudyBean implements Lifecycle {

    private boolean isRunning = false;

    @Override
    public void start() {
        log("Starting...");
        isRunning = true;
    }

    @Override
    public void stop() {
        log("Shutting down...");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
