package com.redmath.news.core;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${news.db.like.operator:%}")
    private String likeOpeator;

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> findAll(String title) {
        logger.debug("findAll: {}", title.replaceAll("[\r\n]", ""));
        return newsRepository.findByTitleLike(likeOpeator + title + likeOpeator);
    }

    public Optional<News> findById(Long id) {
        logger.info("findById: {}", id.toString().replaceAll("[\r\n]", ""));
        Optional<News> news = newsRepository.findById(id);
        if (news.isPresent()) {
            logger.info("news found");
        } else {
            logger.info("news not found");
        }
        return news;
    }

    @Transactional
    public News create(News news) {
        if (news.getId() != null && newsRepository.existsById(news.getId())) {
            logger.warn("News already exist: {}", news.getId());
            return null;
        }
        news.setId(System.currentTimeMillis());
        news.setReportedAt(LocalDateTime.now());
        return newsRepository.save(news);
    }
}
