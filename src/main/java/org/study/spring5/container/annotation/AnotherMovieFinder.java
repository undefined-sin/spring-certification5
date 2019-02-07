package org.study.spring5.container.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.study.spring5.StudyBean;

public class AnotherMovieFinder extends StudyBean {

    @Autowired
    private MovieFinderDao dao;

    public void setDao(MovieFinderDao dao) {
        this.dao = dao;
    }

    public void listMovies() {
        this.listFromDao(dao);
    }

    private void listFromDao(MovieFinderDao dao) {
        dao.findAll("Harry")
                .stream().map(m -> "Found movie: " + m)
                .forEach(this::log);
    }
}
