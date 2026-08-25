package com.example.pais_boulabgeries_app.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class HttpResponseDto {
    private HttpStatus httpStatus;

    private String message;

    private Object responseData;
}
