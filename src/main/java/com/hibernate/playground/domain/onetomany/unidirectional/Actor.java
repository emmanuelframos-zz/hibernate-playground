package com.hibernate.playground.domain.onetomany.unidirectional;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /** Avoid: No default constructor for entity. **/
    private Actor(){}

    public Actor(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Actor{id=%d, name=%s}", id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(id, actor.id) && Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}