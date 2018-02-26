package com.hibernate.playground.repository;

import com.hibernate.playground.domain.onetomany.bidirectional.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository <Game, Long> { }
