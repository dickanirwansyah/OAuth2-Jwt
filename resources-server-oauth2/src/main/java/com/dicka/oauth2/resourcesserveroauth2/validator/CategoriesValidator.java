package com.dicka.oauth2.resourcesserveroauth2.validator;


import com.dicka.oauth2.resourcesserveroauth2.entity.Categories;
import com.dicka.oauth2.resourcesserveroauth2.validation.CategoriesValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CategoriesValidator implements ConstraintValidator<CategoriesValidation, Categories> {

    @Override
    public void initialize(CategoriesValidation constraintValidation) {

    }

    @Override
    public boolean isValid(Categories value, ConstraintValidatorContext context) {

        if(value == null)
            return true;

        if (value.getName() == null && value.getName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Sorry Name is required !")
                    .addPropertyNode("name").addConstraintViolation();
            return false;
        }

        if (value.getDescription() == null && value.getDescription().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Sorry Description is required !")
                    .addPropertyNode("description").addConstraintViolation();
            return false;
        }

        return true;
    }
}
