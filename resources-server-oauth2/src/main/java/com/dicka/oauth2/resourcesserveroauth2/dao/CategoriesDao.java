package com.dicka.oauth2.resourcesserveroauth2.dao;



import com.dicka.oauth2.resourcesserveroauth2.entity.Categories;

import java.util.List;

public interface CategoriesDao {

    Categories saveCategories(Categories categories);

    void deleteCategories(Categories categories);

    List<Categories> allCategories();

    Categories findById(Long idcategories);
}
