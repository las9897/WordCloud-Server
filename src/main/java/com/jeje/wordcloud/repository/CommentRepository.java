package com.jeje.wordcloud.repository;

import com.jeje.wordcloud.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
