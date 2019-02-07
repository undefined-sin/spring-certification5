package org.study.spring5.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;
import org.study.spring5.StudyBean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedHashSet;
import java.util.Set;

public class PoemLoader extends StudyBean {

    private Set<Resource> resources = new LinkedHashSet<>();


    public PoemLoader(Set<Resource> resource) {
        this.resources.addAll(resource);
    }

    public void printContent() {
        this.resources.forEach(this::consumeResource);

    }

    private void consumeResource(Resource resource) {
        try (InputStream is = resource.getInputStream()) {
            log("Loading file %s", resource.getFile().toString());
            String content = StreamUtils.copyToString(is, Charset.defaultCharset());
            log(content);
        } catch (IOException e) {
            log("Could not load resource %s", this.resources.toString());
        }
    }
}
