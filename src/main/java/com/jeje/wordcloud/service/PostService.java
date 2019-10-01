package com.jeje.wordcloud.service;

import com.jeje.wordcloud.entity.PostEntity;
import com.jeje.wordcloud.repository.CommentRepository;
import com.jeje.wordcloud.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface PostService {
    List<PostEntity> getPostListByCreateDate(Date create_date);

}
