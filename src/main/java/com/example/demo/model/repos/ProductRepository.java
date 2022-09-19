package com.example.demo.model.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByCategoryId(long i, Pageable page);

}
