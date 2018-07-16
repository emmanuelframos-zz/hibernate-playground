package com.hibernate.playground.rest;

import com.hibernate.playground.domain.onetomany.unidirectional.Film;
import com.hibernate.playground.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmRestController {

    @Autowired
    private FilmService filmService;

    @PostMapping(value = "/film")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Film film){
        filmService.save(film);
    }

    @GetMapping(value = "/film/{id}")
    public Film create(@PathVariable Long id){
        return filmService.findOne(id);
    }
}
