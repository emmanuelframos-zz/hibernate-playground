package com.test;

import com.hibernate.playground.domain.onetomany.bidirectional.Game;
import com.hibernate.playground.domain.onetomany.bidirectional.Player;
import com.hibernate.playground.service.GameService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class OneToManyBidirectionalTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(OneToManyBidirectionalTest.class);

    @Autowired
    private GameService gameService;

    @Test
    public void saveGame(){

        Player playerOne = new Player("Player One");
        Player playerTwo = new Player("Player Two");

        Game game = new Game("Game One");
        game.addPlayers(playerOne).addPlayers(playerTwo);

        game = gameService.save(game);

        logger.info(game.toString());

    }

}
