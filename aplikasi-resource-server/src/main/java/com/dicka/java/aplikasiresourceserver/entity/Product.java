package com.dicka.java.aplikasiresourceserver.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product",
        catalog = "aplikasi_resource_server")
public class Product implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",  strategy = "uuid2")
    private String idproduct;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "idcategories", nullable = false)
    private Categories categories;

    @Column(name = "disabled")
    private int disabled;

    @Column(name = "image", length = Integer.MAX_VALUE)
    @Lob
    private byte[] image;

    public String getIdproduct(){
        return idproduct;
    }

    public void setIdproduct(String idproduct){
        this.idproduct = idproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories){
        this.categories = categories;
    }

    public int getDisabled(){
        return disabled;
    }

    public void setDisabled(int disabled){
        this.disabled = disabled;
    }

    public byte[] getImage(){
        return image;
    }

    public void setImage(byte[] image){
        this.image = image;
    }
}
