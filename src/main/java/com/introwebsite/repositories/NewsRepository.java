package com.introwebsite.repositories;

import com.introwebsite.entities.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
}
