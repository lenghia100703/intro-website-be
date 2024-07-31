package com.introwebsite.controllers;

import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.news.NewsDto;
import com.introwebsite.dtos.product.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/search")
public interface SearchController {
    @GetMapping("/news")
    PaginatedDataDto<NewsDto> searchNews(@RequestParam(name = "page") int page, @RequestParam(name = "q") String q);

    @GetMapping("/product")
    PaginatedDataDto<ProductDto> searchProduct(@RequestParam(name = "page") int page, @RequestParam(name = "q") String q);
}
