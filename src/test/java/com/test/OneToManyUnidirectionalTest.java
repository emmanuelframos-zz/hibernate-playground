package com.test;

import com.hibernate.playground.domain.onetomany.unidirectional.Actor;
import com.hibernate.playground.domain.onetomany.unidirectional.Film;
import com.hibernate.playground.service.FilmService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class OneToManyUnidirectionalTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(OneToManyUnidirectionalTest.class);

    @Autowired
    private FilmService filmService;

    @Test
    public void saveFilmAndRemoveActorAfter(){
        Actor actorOne = new Actor("Actor One");
        Actor actorTwo = new Actor("Actor Two");

        Film film = new Film("Film One");
        film.addActor(actorOne).addActor(actorTwo);

        filmService.save(film);

        film = filmService.findOne(film.getId());

        film.removeActor(film.getActors().iterator().next());

        filmService.save(film);

        logger.info(film.toString());

    }
}
