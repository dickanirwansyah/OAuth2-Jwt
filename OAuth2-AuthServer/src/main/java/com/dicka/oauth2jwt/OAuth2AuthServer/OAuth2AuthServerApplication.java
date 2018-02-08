package com.dicka.oauth2jwt.OAuth2AuthServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class OAuth2AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2AuthServerApplication.class, args);
	}
}
