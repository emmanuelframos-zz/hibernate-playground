package com.hibernate.playground.domain.onetomany.bidirectional;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private BigDecimal name;

    @ManyToOne
    private Game game;

}