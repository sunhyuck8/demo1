package com.bhome.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List getSubCategoryList(String categoryName);
}
