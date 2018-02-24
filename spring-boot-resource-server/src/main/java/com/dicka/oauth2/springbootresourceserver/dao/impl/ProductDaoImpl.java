package com.dicka.oauth2.springbootresourceserver.dao.impl;

import com.dicka.oauth2.springbootresourceserver.dao.ProductDao;
import com.dicka.oauth2.springbootresourceserver.entity.Product;
import com.dicka.oauth2.springbootresourceserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

    private final ProductRepository productRepository;

    @Autowired
    public ProductDaoImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(String idproduct) {
        return productRepository.findOne(idproduct);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product disabled(Product product) {
        return productRepository.save(product);
    }
}
