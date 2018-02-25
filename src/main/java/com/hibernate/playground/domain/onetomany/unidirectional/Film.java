package com.hibernate.playground.domain.onetomany.unidirectional;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Actor> actors;

}
