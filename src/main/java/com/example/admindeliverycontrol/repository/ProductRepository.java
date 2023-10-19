package com.example.admindeliverycontrol.repository;

import com.example.admindeliverycontrol.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
