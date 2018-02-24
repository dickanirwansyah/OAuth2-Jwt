package com.dicka.oauth2.springbootresourceserver.entity;

import com.dicka.oauth2.springbootresourceserver.validation.ValidationCategories;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@ValidationCategories
@Table(name = "categories",
        catalog = "aplikasi_resource_server")
public class Categories implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategories;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "makedate", nullable = false)
    private Date makedate;

    @Column(name = "disabled", nullable = false)
    private int disabled;

    @JsonIgnore
    @OneToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<Product>();

    public Categories(){}

    public Categories(String name, String description, Date makedate, int disabled){
        this.name = name;
        this.description = description;
        this.makedate = makedate;
        this.disabled = disabled;
    }

    public List<Product> getProducts(){
        return products;
    }

    public void setProducts(List<Product> products){
        this.products = products;
    }

    public Long getIdcategories(){
        return idcategories;
    }

    public void setIdcategories(Long idcategories){
        this.idcategories = idcategories;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Date getMakedate(){
        return makedate;
    }

    public void setMakedate(Date makedate){
        this.makedate = makedate;
    }

    public int getDisabled(){
        return disabled;
    }

    public void setDisabled(int disabled){
        this.disabled = disabled;
    }
}
