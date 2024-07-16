package com.introwebsite.controllers.impl;

import com.introwebsite.controllers.ProductController;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.product.ProductDto;
import com.introwebsite.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ProductControllerImpl implements ProductController {
    @Autowired
    ProductService productService;

    @Override
    public CommonResponseDto<ProductDto> getProductById(Long id) {
        return productService.getProductById(id);
    }

    @Override
    public PaginatedDataDto<ProductDto> getProductByPage(int page) {
        return productService.getProductByPage(page);
    }

    @Override
    public CommonResponseDto<ProductDto> createProduct(MultipartFile file, String name, String description, String image) throws IOException {
        return productService.createProduct(name, description, image, file);
    }

    @Override
    public CommonResponseDto<String> editProduct(Long id, MultipartFile file, String name, String description, String image) throws IOException {
        return productService.editProduct(id, name, description, image, file);
    }

    @Override
    public CommonResponseDto<String> deleteProduct(Long id) {
        return productService.deleteProduct(id);
    }
}
