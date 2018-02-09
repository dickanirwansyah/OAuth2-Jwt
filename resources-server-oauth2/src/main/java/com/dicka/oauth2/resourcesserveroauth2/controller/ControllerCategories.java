package com.dicka.oauth2.resourcesserveroauth2.controller;


import com.dicka.oauth2.resourcesserveroauth2.entity.Categories;
import com.dicka.oauth2.resourcesserveroauth2.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class ControllerCategories {

    private final CategoriesService categoriesService;

    @Autowired
    public ControllerCategories(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Categories>> getAllCategories(){
        return Optional.ofNullable(categoriesService.findAll())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Categories>>(HttpStatus.BAD_REQUEST));
    }
}
