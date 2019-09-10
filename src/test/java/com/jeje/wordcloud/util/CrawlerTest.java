package com.jeje.wordcloud.util;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrawlerTest {

    private Crawler crawler = new Crawler();

    @Test
    public void crawlerTest () throws Exception {
        int numberOfCrawler = 7;
        String crawlStorageFolder = "data/crawl";

        CrawlConfig config = new CrawlConfig();
        config.setMaxDepthOfCrawling(0); // 최대 깊이 값 조절
        config.setPolitenessDelay(500); // 딜레이
        config.setCrawlStorageFolder(crawlStorageFolder);

        /*
         *  프록시도 사용 가능
        config.setProxyHost("프록시주소");
        config.setProxyPort(8080);
        config.setProxyUsername(username);
        config.setProxyPassword(password);
        */


        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.addSeed("https://okky.kr/article/625959");
        controller.start(Crawler.class, numberOfCrawler);


    }

}