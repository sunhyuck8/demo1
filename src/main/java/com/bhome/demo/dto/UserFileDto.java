package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFileDto {
    private String userPhoto_oriName;
    private String userPhoto_reName;
    private Long userPhoto_size;
    private int users_pk;
}
