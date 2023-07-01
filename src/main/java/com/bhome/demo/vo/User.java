package com.bhome.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class User {


    @NotEmpty
    private String name;
    @NotEmpty
    private String userId;
    @NotEmpty
    private String password;


}
