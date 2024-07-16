package com.introwebsite.controllers.impl;

import com.introwebsite.controllers.NewsController;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.news.NewsDto;
import com.introwebsite.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class NewsControllerImpl implements NewsController {
    @Autowired
    NewsService newsService;

    @Override
    public CommonResponseDto<NewsDto> getNewsById(Long id) {
        return newsService.getNewsById(id);
    }

    @Override
    public PaginatedDataDto<NewsDto> getNewsByPage(int page) {
        return newsService.getNewsByPage(page);
    }

    @Override
    public CommonResponseDto<NewsDto> createNews(MultipartFile file, String title, String description, String image) throws IOException {
        return newsService.createNews(title, description, image, file);
    }

    @Override
    public CommonResponseDto<String> editNews(Long id, MultipartFile file, String title, String description, String image) throws IOException {
        return newsService.editNews(id, title, description, image, file);
    }

    @Override
    public CommonResponseDto<String> deleteNews(Long id) {
        return newsService.deleteNews(id);
    }
}
