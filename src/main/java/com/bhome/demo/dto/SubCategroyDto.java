package com.bhome.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SubCategroyDto {
    private String subCategoryName;
    private int subCategoryNum;
    private int categoryNum;
}
