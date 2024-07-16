package com.introwebsite.repositories;

import com.introwebsite.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmail(String email);

    Optional<UserEntity> findById(Long id);

    @Query("""
            SELECT t FROM UserEntity t WHERE t.role <> com.introwebsite.enums.Role.OWNER""")
    List<UserEntity> findAllUserByRole();
}
