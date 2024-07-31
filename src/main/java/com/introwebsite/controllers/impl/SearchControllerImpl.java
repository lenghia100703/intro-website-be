package com.introwebsite.controllers.impl;

import com.introwebsite.controllers.SearchController;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.news.NewsDto;
import com.introwebsite.dtos.product.ProductDto;
import com.introwebsite.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchControllerImpl implements SearchController {
    @Autowired
    SearchService searchService;

    @Override
    public PaginatedDataDto<NewsDto> searchNews(int page, String q) {
        return searchService.searchNews(page, q);
    }

    @Override
    public PaginatedDataDto<ProductDto> searchProduct(int page, String q) {
        return searchService.searchProduct(page, q);
    }
}
