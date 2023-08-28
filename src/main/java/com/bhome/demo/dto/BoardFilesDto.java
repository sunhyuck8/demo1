package com.bhome.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor //모든 필드에 대한 인수를 수락하는 생성자 생성해줌
@NoArgsConstructor  //모든 필드를 기본값으로 초기화시켜줌
public class BoardFilesDto {
    private int boardFiles_pk;
    private String boardFiles_oriName;
    private String boardFiles_reName;
    private int boardFiles_size;
    private int board_pk;
    /*multipartList들어갈예정*/
}
