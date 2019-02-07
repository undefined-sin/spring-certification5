package org.study.spring5.container.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.study.spring5.StudyBean;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Set;

public class MovieFinder extends StudyBean {

    @Autowired
    @Qualifier("movieFinderDao")
    private MovieFinderDao movieFinderDao;


    // Using @Inject and method based.
    private MovieFinderDao movieFinderDao2;


    @Resource(name = "movieFinderDao")
    private MovieFinderDao movieFinderDao3;

    private Set<MovieFinderDao> daos;


    public MovieFinderDao getMovieFinderDao() {
        return movieFinderDao;
    }


    public void setMovieFinderDao(MovieFinderDao movieFinderDao) {
        this.movieFinderDao = movieFinderDao;
    }

    public MovieFinderDao getMovieFinderDao2() {
        return movieFinderDao2;
    }

    @Inject
    @Named("movieFinderDao2")
    public void setMovieFinderDao2(MovieFinderDao movieFinderDao2) {
        this.movieFinderDao2 = movieFinderDao2;
    }

    public void setMovieFinderDao3(MovieFinderDao movieFinderDao3) {
        this.movieFinderDao3 = movieFinderDao3;
    }

    // Autowiring Set with all beans.
    @Autowired
    public void setDaos(Set<MovieFinderDao> daos) {
        this.daos = daos;
    }

    public void listMovies() {
        log("First dao");
        listFromDao(movieFinderDao);
        log("Second dao");
        listFromDao(movieFinderDao2);
        log("Third dao");
        listFromDao(movieFinderDao3);
        this.daos.stream().forEach(this::listFromDao);

    }

    private void listFromDao(MovieFinderDao dao) {
        dao.findAll("Harry")
                .stream().map(m -> "Found movie: " + m)
                .forEach(this::log);
    }
}
