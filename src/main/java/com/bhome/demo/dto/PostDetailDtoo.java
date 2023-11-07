package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailDtoo {

    private int post_pk;
    private String post_title;
    private String post_content;
    private int users_pk;
    private String user_name;
    private String post_category_name;
    private String post_subcategory_name;
    private LocalDateTime post_createdAt;
    private List<Post_files> post_files;
}
