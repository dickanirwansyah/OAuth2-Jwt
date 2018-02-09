package com.dicka.oauth2.resourcesserveroauth2.service;



import com.dicka.oauth2.resourcesserveroauth2.entity.Categories;

import java.util.List;

public interface CategoriesService {

    List<Categories> findAll();

    Categories findById(Long idcategories);

    Categories saveCategories(Categories categories);

}
