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
}
