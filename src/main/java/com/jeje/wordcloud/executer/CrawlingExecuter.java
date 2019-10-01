package com.jeje.wordcloud.executer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrawlingExecuter {

    @Scheduled(cron = "0 0/5 * * * ?")
    public synchronized void getPostComment(){

    }

    /*
    *
    * */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public synchronized void collectWord(){

    }

}
