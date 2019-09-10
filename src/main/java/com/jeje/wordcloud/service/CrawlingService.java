package com.jeje.wordcloud.service;

import com.jeje.wordcloud.vo.PostVO;

import java.util.List;

public interface CrawlingService {
    public List<PostVO> crawlingList(String board);
    public List<PostVO> crawlingPost();

}
