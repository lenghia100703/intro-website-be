package com.introwebsite.services.impl;

import com.introwebsite.constants.PageableConstants;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.news.NewsDto;
import com.introwebsite.entities.NewsEntity;
import com.introwebsite.enums.ResponseCode;
import com.introwebsite.exceptions.CommonException;
import com.introwebsite.repositories.NewsRepository;
import com.introwebsite.services.NewsService;
import com.introwebsite.services.UserService;
import com.introwebsite.utils.GithubUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserService userService;

    @Autowired
    GithubUtil githubUtil;

    @Override
    public CommonResponseDto<NewsDto> getNewsById(Long id) {
        return new CommonResponseDto<>(new NewsDto(Objects.requireNonNull(newsRepository.findById(id).orElse(null))));
    }

    @Override
    public PaginatedDataDto<NewsDto> getNewsByPage(int page) {
        List<NewsEntity> allNews = newsRepository.findAll();
        if (page >= 1) {
            Pageable pageable = PageRequest.of(page - 1, PageableConstants.LIMIT);
            Page<NewsEntity> newsPage = newsRepository.findAll(pageable);

            List<NewsDto> newsDtos = newsPage.getContent().stream()
                    .map(NewsDto::new)
                    .collect(Collectors.toList());

            return new PaginatedDataDto<>(newsDtos, page, allNews.toArray().length);
        } else {
            List<NewsDto> newsDtos = allNews.stream()
                    .map(NewsDto::new)
                    .collect(Collectors.toList());
            return new PaginatedDataDto<>(newsDtos, 1, allNews.toArray().length);
        }
    }

    @Override
    public CommonResponseDto<NewsDto> createNews(String title, String description, String image, MultipartFile file) throws IOException {
        NewsEntity news = new NewsEntity();
        news.setTitle(title);
        news.setDescription(description);
        if (file != null) {
            news.setImage(githubUtil.uploadImage(file, "news"));
        } else {
            news.setImage(image);
        }
        news.setCreatedAt(new Date(System.currentTimeMillis()));
        news.setCreatedBy(userService.getCurrentUser().getEmail());

        return new CommonResponseDto<>(new NewsDto(newsRepository.save(news)));
    }

    @Override
    public CommonResponseDto<String> editNews(Long id, String title, String description, String image, MultipartFile file) throws IOException {
        NewsEntity news = newsRepository.getById(id);
        if (news == null) {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }

        news.setTitle(title);
        news.setDescription(description);
        news.setUpdatedBy(userService.getCurrentUser().getEmail());
        news.setUpdatedAt(new Date(System.currentTimeMillis()));

        if (file != null) {
            news.setImage(githubUtil.uploadImage(file, "news"));
        } else {
            news.setImage(image);
        }

        newsRepository.save(news);
        return new CommonResponseDto<>("Edited successfully");
    }

    @Override
    public CommonResponseDto<String> deleteNews(Long id) {
        NewsEntity news = newsRepository.getById(id);
        if (news == null) {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }

        newsRepository.delete(news);
        return new CommonResponseDto<>("Deleted successfully");
    }
}
