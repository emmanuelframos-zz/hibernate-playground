package com.hibernate.playground.domain.onetomany.unidirectional;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Actor> actors;

    /** Avoid: No default constructor for entity. **/
    private Film(){}

    public Film(String name) {
        this.name = name;
        this.actors = new HashSet<>();
    }

    public Film addActor(Actor actor){
        this.actors.add(actor);
        return this;
    }

    public Film removeActor(Actor actor){
        this.actors.remove(actor);
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return String.format("Film{id=%d, name=%s, actors=%s}",
                id, name, actors.stream().map(Actor::toString).collect(Collectors.joining(", ")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(name, film.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}