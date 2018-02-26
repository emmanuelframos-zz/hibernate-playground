package com.hibernate.playground.repository;

import com.hibernate.playground.domain.onetoone.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <Post, Long> { }
