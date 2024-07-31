package com.introwebsite.services;

import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.news.NewsDto;
import com.introwebsite.dtos.product.ProductDto;

public interface SearchService {
    PaginatedDataDto<ProductDto> searchProduct(int page, String q);

    PaginatedDataDto<NewsDto> searchNews(int page, String q);
}
