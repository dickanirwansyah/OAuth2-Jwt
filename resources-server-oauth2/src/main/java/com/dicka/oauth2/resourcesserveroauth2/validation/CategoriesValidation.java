package com.dicka.oauth2.resourcesserveroauth2.validation;



import com.dicka.oauth2.resourcesserveroauth2.validator.CategoriesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {
        CategoriesValidator.class
})
public @interface CategoriesValidation {

    String message()
            default "Opps sorry something wrong";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};
}
