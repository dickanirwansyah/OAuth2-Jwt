package com.dicka.oauth2jwt.OAuth2AuthServer.entity;

import org.springframework.security.core.userdetails.User;

public class UsersDetails extends User {

    private static final long serialVersionUID=1L;

    public UsersDetails(UserEntity userEntity){
        super(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getGrantedAuthorities());
    }
}
