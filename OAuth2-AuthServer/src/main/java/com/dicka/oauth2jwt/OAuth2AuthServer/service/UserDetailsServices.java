package com.dicka.oauth2jwt.OAuth2AuthServer.service;

import com.dicka.oauth2jwt.OAuth2AuthServer.dao.UserDao;
import com.dicka.oauth2jwt.OAuth2AuthServer.entity.UserEntity;
import com.dicka.oauth2jwt.OAuth2AuthServer.entity.UsersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServices implements UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userDao.getUserDetails(username);
        UsersDetails usersDetails = new UsersDetails(userEntity);
        return usersDetails;
    }
}
