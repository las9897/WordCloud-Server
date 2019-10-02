package com.jeje.wordcloud.util;

import com.jeje.wordcloud.converter.PostToEntityConverter;
import com.jeje.wordcloud.dto.Post;
import com.jeje.wordcloud.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlerTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    public void 게시글을_저장한다() throws Exception {
        PostToEntityConverter converter = new PostToEntityConverter();
        Post post = JsoupCrawler.crawling("https://okky.kr/article/7");
        if(post == null){
            return ;
        }
        postRepository.save(converter.convert(post));
    }
}