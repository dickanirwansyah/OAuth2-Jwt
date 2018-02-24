package com.dicka.oauth2.springbootresourceserver.validator;

import com.dicka.oauth2.springbootresourceserver.entity.Categories;
import com.dicka.oauth2.springbootresourceserver.validation.ValidationCategories;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidatorCategories implements ConstraintValidator<ValidationCategories, Categories> {


    @Override
    public void initialize(ValidationCategories constraintAnnotation) {

    }

    @Override
    public boolean isValid(Categories value, ConstraintValidatorContext context) {

        if (value == null)
            return true;

        if (value.getName() == null || value.getName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Name is required !")
                    .addPropertyNode("name").addConstraintViolation();
            return false;
        }

        if (value.getDescription() == null || value.getDescription().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Description is required !")
                    .addPropertyNode("description").addConstraintViolation();
            return false;
        }

        return true;
    }
}
