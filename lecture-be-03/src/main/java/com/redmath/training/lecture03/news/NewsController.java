package com.redmath.training.lecture03.news;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/api/v1/news/{newsId}")
    public ResponseEntity<News> get(@PathVariable("newsId") Long newsId) {
        Optional<News> news = newsService.findById(newsId);
        if (news.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(news.get());
    }

    @GetMapping("/api/v1/news")
    public ResponseEntity<List<News>> get(@RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "page", defaultValue = "1000") Integer size) {
        return ResponseEntity.ok(newsService.findAll(page, size));
    }

    @PostMapping("/api/v1/news")
    public ResponseEntity<News> create(@RequestBody News news) {
        news = newsService.create(news);
        return ResponseEntity.created(URI.create("/api/v1/news/" + news.getNewsId())).body(news);
    }
}