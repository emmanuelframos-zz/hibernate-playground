package com.hibernate.playground.domain.onetomany.bidirectional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Player> players;

    /** Avoid: No default constructor for entity. **/
    private Game(){}

    public Game(String name) {
        this.name = name;
        this.players = new HashSet<>();
    }

    public Game addPlayers(Player player){
        this.players.add(player);
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return String.format("Game{id=%d, name=%s, players=%s}", id, name, players);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}