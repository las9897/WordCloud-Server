package com.jeje.wordcloud.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupCrawler {
    private String url;


    public JsoupCrawler(String url) {
        this.url = url;
    }

    public void crawling() throws Exception {

        Document doc = Jsoup.connect(url).get();

        System.out.println("HTML TITLE: " + doc.title());


        // 타이틀: <h2 class="panel-title">
        // TITLE : #content-body > h2
        // CONTENT : #content-body > article

        String title = doc.title();
        String content = doc.selectFirst("#content-body > h2").text();


        Elements comments = doc.select("#article > div:nth-child(4) > ul > li > form > div > fieldset > article");
        for (Element comment : comments) {
            // TODO: COMMENT ENTITY에 담아서 저장
            System.out.println(comment.text());
        }

    }
}
