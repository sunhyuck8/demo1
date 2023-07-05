package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor //모든 필드에 대한 인수를 수락하는 생성자 생성해줌
@NoArgsConstructor  //모든 필드를 기본값으로 초기화시켜줌
//@Data를 안쓰는 이유 :  @setter를 지양하기 위해서
public class BoardFilesDto {
    private int boardFiles_pk;
    private String boardFiles_oriName;
    private String boardFiles_reName;
    private int boardFiles_size;
    private int board_pk;
    /*multipartList들어갈예정*/
}
