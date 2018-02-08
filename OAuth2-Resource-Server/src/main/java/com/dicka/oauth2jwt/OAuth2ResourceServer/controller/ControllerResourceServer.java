package com.dicka.oauth2jwt.OAuth2ResourceServer.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/resource")
public class ControllerResourceServer {

    //has role CUSTOMER_ADMIN
    @GetMapping
    @PreAuthorize("hasRole('CUSTOMER_ADMIN')")
    public String getCustomerAdmin(){
        return "INI JSON DATA HAK AKSES CUSTOMER_ADMIN";
    }

    //has role SYSTEM_ADMIN
    @GetMapping(value = "/sys")
    @PreAuthorize("hasRole('SYSTEMADMIN')")
    public String getSystemAdmin(){
        return "INI JSON DATA HAK AKSES SYSTEMADMIN";
    }
}
