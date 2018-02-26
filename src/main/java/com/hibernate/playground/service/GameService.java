package com.hibernate.playground.service;

import com.hibernate.playground.domain.onetomany.bidirectional.Game;
import com.hibernate.playground.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public Game findOne(Long id){
        return gameRepository.findOne(id);
    }

    @Transactional
    public Game save(Game game){
        return gameRepository.save(game);
    }

}