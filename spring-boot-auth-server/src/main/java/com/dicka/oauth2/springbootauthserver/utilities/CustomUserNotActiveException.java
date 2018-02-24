package com.dicka.oauth2.springbootauthserver.utilities;


import org.springframework.security.core.AuthenticationException;

public class CustomUserNotActiveException extends AuthenticationException {

    public CustomUserNotActiveException(String msg, Throwable t) {
        super(msg, t);
    }

    public CustomUserNotActiveException(String msg) {
        super(msg);
    }
}
