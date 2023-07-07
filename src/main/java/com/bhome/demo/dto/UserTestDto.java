package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserTestDto {
    private int user_pk;
    private String user_id;
    private String user_pass;
}
