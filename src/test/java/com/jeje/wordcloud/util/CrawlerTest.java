package com.jeje.wordcloud.util;


public class CrawlerTest {



    public static void main(String[] args) throws Exception {
        JsoupCrawler crawler = new JsoupCrawler("https://okky.kr/article/629465");

        crawler.crawling();


    }


}