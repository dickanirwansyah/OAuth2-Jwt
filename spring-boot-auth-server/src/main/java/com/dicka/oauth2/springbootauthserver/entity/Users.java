package com.dicka.oauth2.springbootauthserver.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

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
    private String iduser;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Email(message = "Sorry Email Not Valid")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "activated")
    private boolean activated;

    @Column(name = "activationkey")
    private String activationKey;

    @Column(name = "resetpasswordkey")
    private String resetPasswordKey;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_role", joinColumns =
    @JoinColumn(name = "iduser", referencedColumnName = "iduser"), inverseJoinColumns =
    @JoinColumn(name = "idrole", referencedColumnName = "idrole"))
    private List<Role> roleList = new ArrayList<Role>();

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getResetPasswordKey(){
        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey){
        this.resetPasswordKey = resetPasswordKey;
    }

    public String getActivationKey(){
        return activationKey;
    }

    public void setActivationKey(String activationKey){
        this.activationKey = activationKey;
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

    public List<Role> getRoleList(){
        return roleList;
    }

    public void setRoleList(List<Role> roleList){
        this.roleList = roleList;
    }
}
