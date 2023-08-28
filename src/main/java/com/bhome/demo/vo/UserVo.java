package com.bhome.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private int users_pk;
    @NotBlank
    private String user_id;
    @NotBlank
    private String user_pass;
    @NotBlank
    private String user_name;
    private String userPhoto_reName;
}
