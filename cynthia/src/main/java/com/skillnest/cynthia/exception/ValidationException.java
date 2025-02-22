package com.skillnest.cynthia.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationException extends RuntimeException{

    private int status;
    private String message;

}
