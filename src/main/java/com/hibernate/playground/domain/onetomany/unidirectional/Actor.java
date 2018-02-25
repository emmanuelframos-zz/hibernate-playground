package com.hibernate.playground.domain.onetomany.unidirectional;

import javax.persistence.*;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
