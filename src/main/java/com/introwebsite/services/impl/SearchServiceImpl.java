package com.introwebsite.services.impl;

import com.introwebsite.constants.PageableConstants;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.news.NewsDto;
import com.introwebsite.dtos.product.ProductDto;
import com.introwebsite.entities.NewsEntity;
import com.introwebsite.entities.ProductEntity;
import com.introwebsite.repositories.NewsRepository;
import com.introwebsite.repositories.ProductRepository;
import com.introwebsite.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public PaginatedDataDto<ProductDto> searchProduct(int page, String q) {
        List<ProductEntity> allProduct = productRepository.findAll();
        if (page >= 1 && !Objects.equals(q, "")) {
            Pageable pageable = PageRequest.of(page - 1, PageableConstants.LIMIT);
            Page<ProductEntity> productPage = productRepository.findByNameContaining(q, pageable);

            List<ProductEntity> product = productPage.getContent();
            return new PaginatedDataDto<>(product.stream().map(ProductDto::new).toList(), page, allProduct.toArray().length);

        } else if (page < 1 || Objects.equals(q, "")) {
            return new PaginatedDataDto<>(allProduct.stream().map(ProductDto::new).toList(), 1, allProduct.toArray().length);
        }
        return null;
    }

    @Override
    public PaginatedDataDto<NewsDto> searchNews(int page, String q) {
        List<NewsEntity> allNews = newsRepository.findAll();
        if (page >= 1 && !Objects.equals(q, "")) {
            Pageable pageable = PageRequest.of(page - 1, PageableConstants.LIMIT);
            Page<NewsEntity> newsPage = newsRepository.findByTitleContaining(q, pageable);

            List<NewsEntity> news = newsPage.getContent();
            return new PaginatedDataDto<>(news.stream().map(NewsDto::new).toList(), page, allNews.toArray().length);

        } else if (page < 1 || Objects.equals(q, "")) {
            return new PaginatedDataDto<>(allNews.stream().map(NewsDto::new).toList(), 1, allNews.toArray().length);
        }
        return null;
    }
}
