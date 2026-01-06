package com.example.figma2.exception;

import com.example.figma2.payload.ApiResponse;


public class NotFoundException extends RuntimeException {

    public NotFoundException(ApiResponse message) {
        super(message.toString());
    }
}
