package com.dicka.oauth2.resourcesserveroauth2.service.impl;


import com.dicka.oauth2.resourcesserveroauth2.dao.CategoriesDao;
import com.dicka.oauth2.resourcesserveroauth2.entity.Categories;
import com.dicka.oauth2.resourcesserveroauth2.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesDao categoriesDao;

    @Autowired
    public CategoriesServiceImpl(CategoriesDao categoriesDao){
        this.categoriesDao = categoriesDao;
    }

    @Override
    public List<Categories> findAll() {
        return categoriesDao.allCategories();
    }

    @Override
    public Categories findById(Long idcategories) {
        return categoriesDao.findById(idcategories);
    }

    @Override
    public Categories saveCategories(Categories categories) {
        return categoriesDao.saveCategories(categories);
    }
}
