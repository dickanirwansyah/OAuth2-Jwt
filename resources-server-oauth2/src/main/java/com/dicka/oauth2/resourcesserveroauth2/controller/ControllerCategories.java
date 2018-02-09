package com.dicka.oauth2.resourcesserveroauth2.controller;


import com.dicka.oauth2.resourcesserveroauth2.entity.Categories;
import com.dicka.oauth2.resourcesserveroauth2.entity.ErrorResponse;
import com.dicka.oauth2.resourcesserveroauth2.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class ControllerCategories {

    private final CategoriesService categoriesService;

    @Autowired
    public ControllerCategories(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    @PreAuthorize("hasAuthority('ROLE_MASTERADMIN')")
    @GetMapping(value = "/all")
    public ResponseEntity<List<Categories>> getAllCategories(){
        return Optional.ofNullable(categoriesService.findAll())
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Categories>>(HttpStatus.BAD_REQUEST));
    }

    @PreAuthorize("hasAuthority('ROLE_MASTERADMIN')")
    @PostMapping(value = "/created")
    public ResponseEntity<Categories> insertCategories(@Valid @RequestBody Categories categories)
    throws Exception{

        return Optional.ofNullable(categoriesService.saveCategories(categories))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElseThrow(()-> new Exception("400 Bad Request"));
    }

    //error exception handling
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerException(MethodArgumentNotValidException exception){
        String errorMessage = exception.getBindingResult().getFieldErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst().orElse(exception.getMessage());

        return ErrorResponse.builder().message(errorMessage).build();
    }
}
