package com.introwebsite.controllers;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.product.ProductDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/product")
public interface ProductController {
    @GetMapping("/{id}")
    CommonResponseDto<ProductDto> getProductById(@PathVariable("id") Long id);

    @GetMapping("")
    PaginatedDataDto<ProductDto> getProductByPage(@RequestParam(name = "page") int page);

    @PostMapping("")
    CommonResponseDto<ProductDto> createProduct(@RequestParam(value = "file", required = false) MultipartFile file,
                                                @RequestParam("name") String name,
                                                @RequestParam("description") String description,
                                                @RequestParam("image") String image) throws IOException;

    @PutMapping("/{id}")
    CommonResponseDto<String> editProduct(@PathVariable("id") Long id,
                                          @RequestParam(value = "file", required = false) MultipartFile file,
                                          @RequestParam("name") String name,
                                          @RequestParam("description") String description,
                                          @RequestParam("image") String image) throws IOException;


    @DeleteMapping("/{id}")
    CommonResponseDto<String> deleteProduct(@PathVariable("id") Long id);
}
