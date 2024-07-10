package com.redmath.training.lecture04.news;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NewsApiClient {

    private final RestTemplate restTemplate;

    public NewsApiClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Cacheable(cacheNames = "weather")
    public List<News> findNews(String search) {
        String result = restTemplate
                .getForEntity("https://news.google.com/home?hl=en-PK&gl=PK&ceid=PK:en", String.class).getBody();
        News news = new News();
        news.setDetails(result);
        return List.of(news);
    }
}
