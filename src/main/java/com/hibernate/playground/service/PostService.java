package com.hibernate.playground.service;

import com.hibernate.playground.domain.onetoone.Post;
import com.hibernate.playground.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post save(Post post){
        return postRepository.save(post);
    }

}
