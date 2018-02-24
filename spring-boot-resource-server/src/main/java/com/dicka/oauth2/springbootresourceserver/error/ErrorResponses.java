package com.dicka.oauth2.springbootresourceserver.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponses {

    private String message;
}
