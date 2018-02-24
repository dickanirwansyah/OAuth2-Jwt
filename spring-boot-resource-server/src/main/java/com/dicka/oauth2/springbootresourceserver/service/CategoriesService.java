package com.dicka.oauth2.springbootresourceserver.service;

import com.dicka.oauth2.springbootresourceserver.entity.Categories;

import java.util.List;

public interface CategoriesService {

    List<Categories> findAlls();

    Categories findId(Long idcategories);

    Categories created(Categories categories);
}
