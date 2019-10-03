package com.jeje.wordcloud.executer;

import com.jeje.wordcloud.converter.PostToEntityConverter;
import com.jeje.wordcloud.dto.Post;
import com.jeje.wordcloud.repository.PostRepository;
import com.jeje.wordcloud.service.PostService;
import com.jeje.wordcloud.util.JsoupCrawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class CrawlingExecuter {

    @Autowired
    private PostService postService;

    private PostToEntityConverter converter = new PostToEntityConverter();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String BASE_URL = "https://okky.kr/article/";
    private int check = 1;


    @Scheduled(cron = "0 0/2 * * * ?")
    public void getPostComment() {
        if (check >= 630000) return;
        for (int i = 0; i < 100; i++) {
            logger.info("crawling: {}", BASE_URL + check);
            try {
                Thread.sleep(3000);
                Post post = JsoupCrawler.crawling(BASE_URL + check);
                if(post != null)
                    postService.save(converter.convert(post));
            } catch (Exception e) {
                e.printStackTrace();
            }
            check++;
        }
    }

    /*
     *
     * */
 /*   @Scheduled(cron = "0 0 0/1 * * ?")
    public synchronized void collectWord() {

    }
*/
}
