package com.dicka.oauth2.resourcesserveroauth2.entity;

public class ErrorResponse {

    public String message;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
