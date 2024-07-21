package com.introwebsite.dtos.news;

import com.introwebsite.entities.NewsEntity;
import lombok.Data;

import java.util.Date;

@Data
public class NewsDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

    public NewsDto(NewsEntity news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.description = news.getDescription();
        this.image = news.getImage();
        this.createdAt = news.getCreatedAt();
        this.updatedAt = news.getUpdatedAt();
        this.createdBy = news.getCreatedBy();
        this.updatedBy = news.getUpdatedBy();
    }
}
