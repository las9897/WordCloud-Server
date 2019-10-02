package com.jeje.wordcloud.service;

import com.jeje.wordcloud.entity.PostEntity;
import com.jeje.wordcloud.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    private final PostRepository repository;

    @Autowired
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(PostEntity post) {
        repository.save(post);
    }

    @Override
    public List<PostEntity> getPostListByCreateDate(Date create_date) {
        return null;
    }
}
