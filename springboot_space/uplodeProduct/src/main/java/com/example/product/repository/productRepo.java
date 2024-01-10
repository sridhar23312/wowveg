package com.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.product.entity.Product;

public interface productRepo extends JpaRepository<Product, Long> {
@Query(value="select path from productdetails where id=?",nativeQuery = true)
	String getImage(Long id);

}
