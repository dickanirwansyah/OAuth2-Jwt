package com.dicka.oauth2.springbootresourceserver.validation;

import com.dicka.oauth2.springbootresourceserver.validator.ValidatorCategories;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {
        ValidatorCategories.class
})
public @interface ValidationCategories {

    String message()
            default "Ada kesalahan dalam pengisian categories";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};
}
