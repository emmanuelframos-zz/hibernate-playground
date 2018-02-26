package com.hibernate.playground.domain.manytomany.unidirectional;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="value")
    private BigDecimal value;

    /** Avoid: No default constructor for entity. **/
    private Item(){}

    public Item(BigDecimal value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Item{id=%d, value=%f}", id, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(value, item.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}