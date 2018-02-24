package com.dicka.oauth2.springbootresourceserver.service.impl;

import com.dicka.oauth2.springbootresourceserver.dao.CategoriesDao;
import com.dicka.oauth2.springbootresourceserver.entity.Categories;
import com.dicka.oauth2.springbootresourceserver.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    private final CategoriesDao categoriesDao;

    @Autowired
    public CategoriesServiceImpl(CategoriesDao categoriesDao){
        this.categoriesDao = categoriesDao;
    }

    @Override
    public List<Categories> findAlls() {
        return categoriesDao.findAlls();
    }

    @Override
    public Categories findId(Long idcategories) {
        return categoriesDao.findId(idcategories);
    }

    @Override
    public Categories created(Categories categories) {
        return categoriesDao.created(categories);
    }
}
