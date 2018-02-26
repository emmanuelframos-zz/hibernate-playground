package com.hibernate.playground.domain.onetomany.bidirectional;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    private Game game;

    /** Avoid: No default constructor for entity. **/
    private Player(){}

    public Player(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public String toString() {
        return String.format("Player{id=%d, name=%s}", id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}