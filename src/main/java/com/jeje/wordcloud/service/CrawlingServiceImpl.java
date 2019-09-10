package com.jeje.wordcloud.service;

import com.jeje.wordcloud.util.Crawler;
import com.jeje.wordcloud.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrawlingServiceImpl implements CrawlingService{

    private final Crawler crawler;

    private int numberOfCrawler = 5;
    private String crawlStorageFolder = "data/crawl";

    @Override
    public List<PostVO> crawlingList() {
        return null;
    }

    @Override
    public List<PostVO> crawlingPost() {
        return null;
    }
}
