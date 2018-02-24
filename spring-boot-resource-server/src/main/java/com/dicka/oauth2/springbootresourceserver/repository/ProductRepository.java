package com.dicka.oauth2.springbootresourceserver.repository;

import com.dicka.oauth2.springbootresourceserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String>{
}
