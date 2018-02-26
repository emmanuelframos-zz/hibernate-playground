package com.hibernate.playground.service;

import com.hibernate.playground.domain.onetomany.unidirectional.Film;
import com.hibernate.playground.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Transactional(readOnly = true)
    public Film findOne(Long id){
        return filmRepository.findOne(id);
    }

    @Transactional
    public Film save(Film film){
        return filmRepository.save(film);
    }

}