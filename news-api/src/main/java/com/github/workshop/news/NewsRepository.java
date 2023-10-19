package com.github.workshop.news;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    Page<News> findByOrderByIdDesc(Pageable pageable);

    Page<News> findByTitleLikeOrderByIdDesc(Pageable pageable, String title);
}