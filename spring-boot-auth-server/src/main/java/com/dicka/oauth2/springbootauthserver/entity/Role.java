package com.dicka.oauth2.springbootauthserver.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role",
        catalog = "authserver")
public class Role implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idrole;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public Role(){}

    public Role(String idrole, String name, String description){
        this.idrole = idrole;
        this.name = name;
        this.description = description;
    }

    public String getIdrole(){
        return idrole;
    }

    public void setIdrole(String idrole){
        this.idrole = idrole;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description = description;
    }
}
