package org.study.spring5.container.customizing;

import org.study.spring5.StudyBean;

import java.io.Closeable;
import java.io.IOException;

public class CloseableBean extends StudyBean implements Closeable, AutoCloseable {

    @Override
    public void close() throws IOException {
        log("Closing bean");
    }
}
