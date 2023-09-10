package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostFormRegistDto {
    private int post_pk;
    private String post_title;
    private String post_content;
    private int users_pk;
    private String post_category_name;
    private List<MultipartFile> post_files;
}
