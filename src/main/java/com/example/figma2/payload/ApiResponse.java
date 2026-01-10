package com.example.figma2.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ApiResponse {

    private String messege;
    private boolean success;
    private HttpStatus status;
    private  Object body;



}
