package com.jeje.wordcloud.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Comment {

    @NotNull
    private String userID;

    @NotNull
    private String date;

    @NotNull
    private String content;

    private int vote;





}
