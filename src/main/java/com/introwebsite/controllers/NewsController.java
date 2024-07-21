package com.introwebsite.controllers;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.news.NewsDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/news")
public interface NewsController {
    @GetMapping("/{id}")
    CommonResponseDto<NewsDto> getNewsById(@PathVariable("id") Long id);

    @GetMapping("")
    PaginatedDataDto<NewsDto> getNewsByPage(@RequestParam(name = "page") int page);

    @PostMapping("")
    CommonResponseDto<NewsDto> createNews(@RequestParam(value = "file", required = false) MultipartFile file,
                                          @RequestParam("title") String title,
                                          @RequestParam("description") String description,
                                          @RequestParam("image") String image) throws IOException;

    @PutMapping("/{id}")
    CommonResponseDto<String> editNews(@PathVariable("id") Long id,
                                       @RequestParam(value = "file", required = false) MultipartFile file,
                                       @RequestParam("title") String title,
                                       @RequestParam("description") String description,
                                       @RequestParam("image") String image) throws IOException;


    @DeleteMapping("/{id}")
    CommonResponseDto<String> deleteNews(@PathVariable("id") Long id);
}
