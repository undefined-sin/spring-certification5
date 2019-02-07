package org.study.spring5.container.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.study.spring5.StudyBean;

public class YetAnotherMovieFinder extends StudyBean {

    @Autowired
    @Finder
    private MovieFinderDao dao;

    public MovieFinderDao getDao() {
        return dao;
    }

    public void setDao(MovieFinderDao dao) {
        this.dao = dao;
    }

    public void list() {
        this.listFromDao(dao);
    }

    private void listFromDao(MovieFinderDao dao) {
        dao.findAll("Harry")
                .stream().map(m -> "Found movie: " + m)
                .forEach(this::log);
    }
}
