package com.introwebsite.services;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.news.NewsDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface NewsService {
    CommonResponseDto<NewsDto> getNewsById(Long id);

    PaginatedDataDto<NewsDto> getNewsByPage(int page);

    CommonResponseDto<NewsDto> createNews(String title, String description,
                                          String image, MultipartFile file) throws IOException;

    CommonResponseDto<String> editNews(Long id, String title, String description,
                                       String image, MultipartFile file) throws IOException;

    CommonResponseDto<String> deleteNews(Long id);
}
