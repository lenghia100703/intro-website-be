package com.introwebsite.dtos.product;

import com.introwebsite.entities.ProductEntity;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

    public ProductDto(ProductEntity product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
        this.createdBy = product.getCreatedBy();
        this.updatedBy = product.getUpdatedBy();
    }
}
