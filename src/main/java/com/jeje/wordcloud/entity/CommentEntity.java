package com.jeje.wordcloud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@ToString
@Table(name = "TB_COMMENT")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTENT")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date create_date;

}
