package com.hibernate.playground.repository;

import com.hibernate.playground.domain.onetomany.unidirectional.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> { }
