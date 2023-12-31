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
    private Integer post_category_id;
    //selectbox에 null값이 존재하기 때문에 primitive type은 null값을 넣을 수가 없다 , 고로 int > Integer 로 Reference Type으로 변경
    private List<MultipartFile> post_files;
}
