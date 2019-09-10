package com.jeje.wordcloud.controller;


import com.jeje.wordcloud.vo.PostVO;
import com.jeje.wordcloud.service.CrawlingService;
import com.jeje.wordcloud.util.Crawler;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CrawlingAPIController {


    private final CrawlingService crawlingService;

    @GetMapping("/{board}")
    public @ResponseBody
    List<PostVO> crawlingList(@PathVariable("board") String board) {
        return crawlingService.crawlingList(board);
    }

}
