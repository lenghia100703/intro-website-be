package com.introwebsite.services.impl;

import com.introwebsite.constants.PageableConstants;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.product.ProductDto;
import com.introwebsite.entities.ProductEntity;
import com.introwebsite.enums.ResponseCode;
import com.introwebsite.exceptions.CommonException;
import com.introwebsite.repositories.ProductRepository;
import com.introwebsite.services.ProductService;
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
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserService userService;

    @Autowired
    GithubUtil githubUtil;

    @Override
    public CommonResponseDto<ProductDto> getProductById(Long id) {
        return new CommonResponseDto<>(new ProductDto(Objects.requireNonNull(productRepository.findById(id).orElse(null))));
    }

    @Override
    public PaginatedDataDto<ProductDto> getProductByPage(int page) {
        List<ProductEntity> allProducts = productRepository.findAll();
        if (page >= 1) {
            Pageable pageable = PageRequest.of(page - 1, PageableConstants.LIMIT);
            Page<ProductEntity> productPage = productRepository.findAll(pageable);

            List<ProductDto> productDtos = productPage.getContent().stream()
                    .map(ProductDto::new)
                    .collect(Collectors.toList());

            return new PaginatedDataDto<>(productDtos, page, allProducts.toArray().length);
        } else {
            List<ProductDto> productDtos = allProducts.stream()
                    .map(ProductDto::new)
                    .collect(Collectors.toList());
            return new PaginatedDataDto<>(productDtos, 1, allProducts.toArray().length);
        }
    }

    @Override
    public CommonResponseDto<ProductDto> createProduct(String name, String description, String image, MultipartFile file) throws IOException {
        ProductEntity product = new ProductEntity();
        product.setName(name);
        product.setDescription(description);
        if (file != null) {
            product.setImage(githubUtil.uploadImage(file, "product"));
        } else {
            product.setImage(image);
        }
        product.setCreatedAt(new Date(System.currentTimeMillis()));
        product.setCreatedBy(userService.getCurrentUser().getEmail());

        return new CommonResponseDto<>(new ProductDto(productRepository.save(product)));
    }

    @Override
    public CommonResponseDto<String> editProduct(Long id, String name, String description, String image, MultipartFile file) throws IOException {
        ProductEntity product = productRepository.getById(id);
        if (product == null) {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }

        product.setName(name);
        product.setDescription(description);
        product.setUpdatedBy(userService.getCurrentUser().getEmail());
        product.setUpdatedAt(new Date(System.currentTimeMillis()));

        if (file != null) {
            product.setImage(githubUtil.uploadImage(file, "product"));
        } else {
            product.setImage(image);
        }

        productRepository.save(product);
        return new CommonResponseDto<>("Edited successfully");
    }

    @Override
    public CommonResponseDto<String> deleteProduct(Long id) {
        ProductEntity product = productRepository.getById(id);
        if (product == null) {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }

        productRepository.delete(product);
        return new CommonResponseDto<>("Deleted successfully");
    }
}
