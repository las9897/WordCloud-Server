package com.jeje.wordcloud.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
public class CommentVO {
    @JsonProperty("content")
    private String content;
}
