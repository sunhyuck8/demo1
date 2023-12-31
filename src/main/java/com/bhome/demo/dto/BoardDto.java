package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int board_pk;
    private String board_title;
    private String board_content;
    private int board_category_id;
    private int board_subCategoryNum;
    private int user_pk;


    //첨부 이미지들
    private List<BoardFilesDto> boardFileList;
}
