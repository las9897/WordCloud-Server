package com.jeje.wordcloud.dto;

import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private String title;
    private String content;
    private Date create_date;
    private List<Comment> commentList;

 /*   @Builder
    public Post(String title, String content, Date create_date, List<Comment> commentList) {
        this.title = title;
        this.content = content;
        this.create_date = create_date;
        this.commentList = commentList;
    }*/
}
