package com.geektext.apiproject;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
    private List<String> errors;
}
