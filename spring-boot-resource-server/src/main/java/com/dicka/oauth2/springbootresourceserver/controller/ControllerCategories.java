package com.dicka.oauth2.springbootresourceserver.controller;

import com.dicka.oauth2.springbootresourceserver.entity.Categories;
import com.dicka.oauth2.springbootresourceserver.error.ErrorResponses;
import com.dicka.oauth2.springbootresourceserver.service.CategoriesService;
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
@RequestMapping(value = "/api/categories")
public class ControllerCategories {

    private final CategoriesService categoriesService;

    @Autowired
    public ControllerCategories(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    @PreAuthorize("hasAuthority('ROLE_MASTERADMIN')")
    @GetMapping(value = "/all")
    public ResponseEntity<List<Categories>> getAll(){
        return Optional.ofNullable(categoriesService.findAlls())
                .map(resultset -> new ResponseEntity<>(resultset,HttpStatus.OK))
                .orElse(new ResponseEntity<List<Categories>>(HttpStatus.BAD_REQUEST));
    }

    @PreAuthorize("hasAuthority('ROLE_MASTERADMIN')")
    @GetMapping(value = "/get")
    public ResponseEntity<Categories> getId(@RequestParam("idcategories")Long idcategories){
        return Optional.ofNullable(categoriesService.findId(idcategories))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.OK))
                .orElse(new ResponseEntity<Categories>(HttpStatus.BAD_REQUEST));
    }

    @PreAuthorize("hasAuthority('ROLE_MASTERADMIN')")
    @PostMapping(value = "/created")
    public ResponseEntity<Categories> getCreate(@Valid @RequestBody Categories categories)
            throws Exception{

        return Optional.ofNullable(categoriesService.created(categories))
                .map(resultset -> new ResponseEntity<>(resultset, HttpStatus.CREATED))
                .orElseThrow(() -> new Exception("400 Bad Request"));
    }

    //api validation exception
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponses handlerException(MethodArgumentNotValidException exception){

        String responseMessage = exception.getBindingResult()
                .getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst().orElse(exception.getMessage());

        return ErrorResponses.builder().message(responseMessage).build();
    }

}
