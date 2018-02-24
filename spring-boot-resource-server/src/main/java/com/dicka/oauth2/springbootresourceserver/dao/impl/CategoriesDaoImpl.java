package com.dicka.oauth2.springbootresourceserver.dao.impl;

import com.dicka.oauth2.springbootresourceserver.dao.CategoriesDao;
import com.dicka.oauth2.springbootresourceserver.entity.Categories;
import com.dicka.oauth2.springbootresourceserver.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class CategoriesDaoImpl implements CategoriesDao{

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesDaoImpl(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    //update categories & insert categories handling
    @Override
    public Categories created(Categories categories) {
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
    public List<Categories> findAlls() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories findId(Long idcategories) {
        return categoriesRepository.findOne(idcategories);
    }
}
