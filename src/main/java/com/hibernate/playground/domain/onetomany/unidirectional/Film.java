package com.hibernate.playground.domain.onetomany.unidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
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
}