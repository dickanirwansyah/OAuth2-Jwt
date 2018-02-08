package com.dicka.oauth2jwt.OAuth2AuthServer.dao;

import com.dicka.oauth2jwt.OAuth2AuthServer.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserEntity getUserDetails(String username){

        Collection<GrantedAuthority> grantedAuthorityCollection = new ArrayList<>();
        String nativeQuery = "SELECT * FROM USERS WHERE USERNAME=?";
        List<UserEntity> listUserEntity = jdbcTemplate.query(nativeQuery,
                new String[]{username},
                (ResultSet rs, int rowNum)->{
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUsername(username);
                    userEntity.setPassword(rs.getString("PASSWORD"));
                    return userEntity;
                });
        if(listUserEntity!= null && listUserEntity.size()>0){
            GrantedAuthority grantedAuthority =
                    new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
            grantedAuthorityCollection.add(grantedAuthority);
            listUserEntity.get(0)
                    .setGrantedAuthorities(grantedAuthorityCollection);
            return listUserEntity.get(0);
        }
        return null;
    }

}
