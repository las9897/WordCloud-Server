package com.jeje.wordcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Context {


    @NotNull
    private String userID;

    @NotNull
    private String date;

    @NotNull
    private String title;

    @NotNull
    private String content;

    private List<Comment> comments;

    private int vote;

    private int scrap;




}
