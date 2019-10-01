package com.jeje.wordcloud.repository;

import com.jeje.wordcloud.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    @Query("SELECT p FROM  PostEntity  p WHERE MONTH({d '})")
    List<PostEntity> findAll();

}
