package com.introwebsite.dtos.news;

import lombok.Data;

@Data
public class AddNewsDto {
    private String title;
    private String description;
    private String image;
}
