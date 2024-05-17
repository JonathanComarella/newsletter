package com.jonathancomarella.newsletter.controller;

import com.jonathancomarella.newsletter.dto.NewsDto;
import com.jonathancomarella.newsletter.service.NewsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private NewsService service;

    @PostMapping
    public ResponseEntity<NewsDto> createNews(@RequestBody @Valid NewsDto newsDto) {
        NewsDto news = service.createNews(newsDto);
        return ResponseEntity.ok().body(news);
    }
}
