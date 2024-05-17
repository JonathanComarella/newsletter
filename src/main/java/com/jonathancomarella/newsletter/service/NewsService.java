package com.jonathancomarella.newsletter.service;

import com.jonathancomarella.newsletter.dto.NewsDto;

public interface NewsService {

    NewsDto createNews(NewsDto newsDto);
}
