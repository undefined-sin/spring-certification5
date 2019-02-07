package org.study.spring5.container.annotation;

import org.study.spring5.StudyBean;

import java.util.ArrayList;
import java.util.List;

public class MovieFinderDao extends StudyBean {
    public List<String> findAll(String term) {
        log("Finding movie...");
        List<String> list = new ArrayList<>();
        list.add("Harry Potter and the deathly hallows");
        return list;
    }
}
