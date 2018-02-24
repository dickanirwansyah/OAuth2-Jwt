package com.dicka.oauth2.springbootresourceserver.dao;

import com.dicka.oauth2.springbootresourceserver.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();

    Product findOne(String idproduct);

    Product save(Product product);

    Product disabled(Product product);
}
