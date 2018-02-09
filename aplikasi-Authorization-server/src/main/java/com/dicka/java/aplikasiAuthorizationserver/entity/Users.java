package com.dicka.java.aplikasiAuthorizationserver.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users",
        catalog = "authserver")
public class Users implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "iduser", nullable = false, unique = true)
    private String iduser;

    @Column(name = "name", nullable = false)
    private String name;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_role", joinColumns =
    @JoinColumn(name = "iduser", referencedColumnName = "iduser"), inverseJoinColumns =
    @JoinColumn(name = "idrole", referencedColumnName = "idrole"))
    private List<Role> roleList = new ArrayList<>();

    public Users(){}

    public Users(String iduser,
                 String name,
                 String email,
                 String password,
                 boolean activated){

        this.iduser = iduser;
        this.name = name;
        this.email = email;
        this.password = password;
        this.activated = activated;

    }

    public String getIduser(){
        return iduser;
    }

    public void setIduser(String iduser){
        this.iduser = iduser;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public boolean isActivated(){
        return activated;
    }

    public void setActivated(boolean activated){
        this.activated = activated;
    }
}
