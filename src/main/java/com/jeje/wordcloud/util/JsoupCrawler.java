package com.jeje.wordcloud.util;

import com.jeje.wordcloud.dto.Comment;
import com.jeje.wordcloud.dto.Post;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JsoupCrawler {

    private static Logger logger = LoggerFactory.getLogger(JsoupCrawler.class);

    public static Post crawling(String url) throws Exception {

        Connection conn = Jsoup.connect(url);
        Connection.Response response = conn.followRedirects(true).execute();
        logger.info("reponse statusCode: {} url: {}", response.statusCode(), response.url());

        if (true)
            return null;
        Document doc = Jsoup.connect(url)
//                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
//                .header("Sec-Fetch-Mode", "navigate")
//                .header("Sec-Fetch-Site", "none")
//                .header("Sec-Fetch-User", "?1")
//                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                .get();

        // TODO: Redirect된 페이지가 okky.kr 이면 크롤링 종료


        // SETTING
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pattern = "[!@#$%^&*(),.?\":{}|<>ㄱ-ㅎㅏ-ㅣ]";

        // Crawling and Precessing
        String title = doc.title().replaceAll(pattern, "");
        String content = doc.selectFirst("#content-body > h2").text();
        Date create_date = simpleDateFormat.parse(
                doc.selectFirst("#article > div.panel.panel-default.clearfix.fa- > div.panel-heading.clearfix > div.avatar.avatar-medium.clearfix.pull-left > div > div.date-created > span").text()
        );
        Elements elements = doc.select("#article > div:nth-child(4) > ul > li");//> form > div"); // > fieldset > article");

        logger.info("Test Log: {} , {} , {}", title, content, create_date);
        //
        List<Comment> commentList = new ArrayList<>();
        for (int i = 1; i < elements.size() - 1; i++) {
            String comment_content = elements.get(i).selectFirst("form > div > fieldset > article").text().replaceAll(pattern, "");
            Date comment_create_date = simpleDateFormat.parse(elements.get(i).selectFirst("form.note-update-form > div.content-body.panel-body.pull-left > div > div > div.date-created > span:nth-child(1)").text());
            commentList.add(Comment.builder()
                    .content(comment_content)
                    .create_date(comment_create_date)
                    .build());
        }

        //Return Post DTO
        return Post.builder()
                .title(title)
                .content(content)
                .create_date(create_date)
                .commentList(commentList)
                .build();
    }
}
