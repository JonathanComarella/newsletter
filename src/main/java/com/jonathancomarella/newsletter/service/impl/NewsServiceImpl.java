package com.jonathancomarella.newsletter.service.impl;

import com.jonathancomarella.newsletter.dto.NewsDto;
import com.jonathancomarella.newsletter.model.News;
import com.jonathancomarella.newsletter.repository.NewsRepository;
import com.jonathancomarella.newsletter.service.NewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public NewsDto createNews(NewsDto newsDto) {
        News news = modelMapper.map(newsDto, News.class);
        news = newsRepository.save(news);
        return modelMapper.map(news, NewsDto.class);
    }
}
