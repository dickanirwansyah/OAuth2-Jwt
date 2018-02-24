package com.dicka.oauth2.springbootresourceserver.repository;

import com.dicka.oauth2.springbootresourceserver.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long>{
}
