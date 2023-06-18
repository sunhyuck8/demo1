package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppleMapperDTO {
    private int test_id;
    private String name;

    public AppleMapperDTO(String name){
        this.name=name;
    }
}
