package com.introwebsite.services;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.product.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    CommonResponseDto<ProductDto> getProductById(Long id);

    PaginatedDataDto<ProductDto> getProductByPage(int page);

    CommonResponseDto<ProductDto> createProduct(String name, String description,
                                                String image, MultipartFile file) throws IOException;

    CommonResponseDto<String> editProduct(Long id, String name, String description,
                                          String image, MultipartFile file) throws IOException;

    CommonResponseDto<String> deleteProduct(Long id);
}
