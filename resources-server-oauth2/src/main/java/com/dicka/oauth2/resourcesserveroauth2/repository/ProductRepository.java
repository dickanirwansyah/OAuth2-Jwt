package com.dicka.oauth2.resourcesserveroauth2.repository;


import com.dicka.oauth2.resourcesserveroauth2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String>{
}
