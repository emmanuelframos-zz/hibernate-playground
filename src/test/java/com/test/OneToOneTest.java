package com.test;

import com.hibernate.playground.domain.onetoone.Detail;
import com.hibernate.playground.domain.onetoone.Post;
import com.hibernate.playground.service.PostService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class OneToOneTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(OneToOneTest.class);

    @Autowired
    private PostService postService;

    @Test
    public void savePost(){

        Detail detail = new Detail("Detail");

        Post post = new Post("Post");
        post.setDetail(detail);

        post = postService.save(post);

        logger.info(post.toString());

    }
}
