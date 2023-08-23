package com.redmath.news.core;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(value = "select * from News n where n.Title like ?", nativeQuery = true)
    List<News> findByTitleLike(String title);
}
