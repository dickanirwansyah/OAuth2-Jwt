package com.dicka.oauth2.springbootauthserver.utilities;

import com.dicka.oauth2.springbootauthserver.entity.Role;
import com.dicka.oauth2.springbootauthserver.entity.Users;
import com.dicka.oauth2.springbootauthserver.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CustomUserDetailsServices implements UserDetailsService{

    //logger
    private final Logger logger =
            LoggerFactory.getLogger(CustomUserDetailsServices.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login){

        logger.info("Authentication {}", login);
        String lowerCaseLogin = login.toLowerCase();

        Users fromEntityUsers;
        if(lowerCaseLogin.contains("@")){
            fromEntityUsers = usersRepository.findByEmail(lowerCaseLogin);
        }else{
            fromEntityUsers = usersRepository.findByUsernameCaseInsensitive(lowerCaseLogin);
        }

        //validasi
        if(fromEntityUsers == null){

            throw new UsernameNotFoundException("Sory Users "+lowerCaseLogin+ " Not found !");

        }else if(!fromEntityUsers.isActivated()){

            throw new CustomUserNotActiveException("Sorry Users "+lowerCaseLogin+ " Not Active");

        }

        Collection<GrantedAuthority> grantedRoleAuthorities = new ArrayList<>();
        for(Role role : fromEntityUsers.getRoleList()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantedRoleAuthorities.add(grantedAuthority);
        }

        return new User(fromEntityUsers.getUsername(),
                        fromEntityUsers.getPassword(),
                        grantedRoleAuthorities);
    }
}
