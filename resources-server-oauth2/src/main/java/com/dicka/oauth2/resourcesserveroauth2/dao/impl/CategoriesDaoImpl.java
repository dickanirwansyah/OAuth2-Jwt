package com.dicka.oauth2.resourcesserveroauth2.dao.impl;

import com.dicka.oauth2.resourcesserveroauth2.dao.CategoriesDao;
import com.dicka.oauth2.resourcesserveroauth2.entity.Categories;
import com.dicka.oauth2.resourcesserveroauth2.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CategoriesDaoImpl implements CategoriesDao{

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesDaoImpl(CategoriesRepository categoriesRepository){
        this.categoriesRepository=categoriesRepository;
    }

    @Override
    public Categories saveCategories(Categories categories) {
        if(categories.getIdcategories() != null){
            categoriesRepository.save(categories);
        }else{
            categories.setMakedate(new Date());
            categories.setDisabled(1);
            categoriesRepository.save(categories);
        }
        return categories;
    }

    @Override
    public void deleteCategories(Categories categories) {
        categoriesRepository.delete(categories);
    }

    @Override
    public List<Categories> allCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories findById(Long idcategories) {
        return categoriesRepository.findOne(idcategories);
    }
}
