package com.bhome.demo.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegistDto {
    private int user_pk;
    @NotBlank
    private String user_id;
    @NotBlank
    private String user_pass;
    @NotBlank
    private String user_name;
    private MultipartFile photo;
}
