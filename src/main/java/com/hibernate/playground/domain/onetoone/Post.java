package com.hibernate.playground.domain.onetoone;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private Detail detail;

    /** Avoid: No default constructor for entity. **/
    private Post(){}

    public Post(String title){
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail){
        this.detail = detail;
    }

    @Override
    public String toString() {
        return String.format("Post{id=%d, title=%s, detail=%s}", id, title, detail);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}