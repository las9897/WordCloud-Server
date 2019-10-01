package com.jeje.wordcloud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Getter
@ToString
@Table(name = "TB_POST")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "COMMENT")
    private Collection<CommentEntity> comment;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MODIFY_DATE")
    private Date modify_date;


}
