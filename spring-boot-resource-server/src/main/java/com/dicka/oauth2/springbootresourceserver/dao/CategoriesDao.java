package com.dicka.oauth2.springbootresourceserver.dao;

import com.dicka.oauth2.springbootresourceserver.entity.Categories;

import java.util.List;

public interface CategoriesDao{

    Categories created(Categories categories);

    List<Categories> findAlls();

    Categories findId(Long idcategories);
}
