package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardNDto {
    private int board_pk;
    private String board_title;
    private String board_content;
    private String categoryName;
    private String subCategoryName;
    private int user_pk;

    //첨부 이미지들
    private List boardFileList;
}
