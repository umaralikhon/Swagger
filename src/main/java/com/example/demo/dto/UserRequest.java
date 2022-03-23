package com.example.demo.dto;

import lombok.Data;

@Data
public class UserRequest {

    private Long id;
    private String firstname;
    private String lastname;
    private short age;
    private String mail;
}
