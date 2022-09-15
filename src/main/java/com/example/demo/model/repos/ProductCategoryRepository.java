package com.example.demo.model.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
