package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int user_pk;
    private String user_id;
    private String user_pass;
    private String user_name;
    private int user_age;
    private String user_sex;
    private String user_email;
    private String user_intro;
    private LocalDateTime user_signUpdate;
    private LocalDateTime user_withdraw;

    public UserDto(String user_id,String user_pass){
        this.user_id = user_id;
        this.user_pass = user_pass;
    }

    public UserDto(int user_pk,String user_id,String user_pass,String user_name,int user_age,String user_sex,String user_email,String user_intro){
        this.user_pk = user_pk;
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.user_name =user_name;
        this.user_age =user_age;
        this.user_sex =user_sex;
        this.user_email =user_email;
        this.user_intro =user_intro;
    }

    public UserDto(int user_pk){
        this.user_pk = user_pk;
    }

}
