package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post_files {
    private String post_files_oriName;
    private String post_files_reName;
    private long post_files_size;
    private int post_pk;
}
