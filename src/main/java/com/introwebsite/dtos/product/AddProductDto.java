package com.introwebsite.dtos.product;

import lombok.Data;

@Data
public class AddProductDto {
    private String name;
    private String description;
    private String image;
}
