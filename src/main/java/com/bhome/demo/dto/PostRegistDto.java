package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRegistDto {
    private int post_pk;
    private String post_title;
    private String post_content;
    private int users_pk;
    private int post_category_id;
    private List post_files;
}
