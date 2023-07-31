package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //모든 필드에 대한 인수를 수락하는 생성자 생성해줌
@NoArgsConstructor  //모든 필드를 기본값으로 초기화시켜줌
public class PhotoDto {
    private String photo_oriName;
    private String photo_storeName;
    private int photo_size;
    private int user_pk;
}
