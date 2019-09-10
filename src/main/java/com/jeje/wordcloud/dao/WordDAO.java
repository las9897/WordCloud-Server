package com.jeje.wordcloud.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Getter
@NoArgsConstructor
public class WordDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    @NotNull
    private String word;

    @Column(columnDefinition = "integer default 0")
    private int frequency;

    @Builder
    public WordDAO(@NotNull String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
