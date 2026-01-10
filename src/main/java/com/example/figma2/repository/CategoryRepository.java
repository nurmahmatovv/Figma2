package com.example.figma2.repository;

import com.example.figma2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Optional<Category> findByIdAndActiveTrue(Integer id);

}
