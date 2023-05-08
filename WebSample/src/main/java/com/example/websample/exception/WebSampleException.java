package com.example.websample.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WebSampleException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;
}
