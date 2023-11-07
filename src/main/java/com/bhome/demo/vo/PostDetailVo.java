package com.bhome.demo.vo;

import com.bhome.demo.dto.PostCategoryNameDto;
import com.bhome.demo.dto.Post_files;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailVo {
//    @NotBlank
//    int post_pk;
//    @NotNull
//    String post_title;
//    String post_content;
//    @NotBlank
//    String post_category_name;
//    @NotBlank
//    String post_subcategory_name;
//    @NotBlank
//    String user_name;
//    @NotBlank
//    int users_pk;
//    @NotBlank
//    LocalDateTime post_createdAt;
//    List<Post_files> post_files;
    private int post_pk;
    private String post_title;
    private String post_content;
    private String post_category_name;
    private String post_subcategory_name;
    private String user_name;
    private int users_pk;
    private LocalDateTime post_createdAt;
    private List<Post_files> post_files;
}
