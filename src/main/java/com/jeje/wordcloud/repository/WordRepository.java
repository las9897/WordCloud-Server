package com.jeje.wordcloud.repository;

import com.jeje.wordcloud.dao.WordDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<WordDAO, Long> {
}
