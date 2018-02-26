package com.hibernate.playground.domain.onetoone;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "detail")
    private String detail;

    /** Avoid: No default constructor for entity. **/
    private Detail(){}

    public Detail(String detail) {
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return String.format("Detail{id=%d, detail=%s}", id, detail);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return Objects.equals(id, detail.id) && Objects.equals(detail, detail.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, detail);
    }
}
