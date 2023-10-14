package com.bhome.demo.mapper;

import com.bhome.demo.dto.PostFormRegistDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    /*
    [return]
    create - int
    read - list , dto
    update - int
    delete - void
    */
    List getSubCategoryList(String categoryName);   //subCategory 가져오기

    int registPost(PostFormRegistDto postFormRegistDto); //Post한건 등록

    List selectAllPost();   //Post List 가져오기 조건 x



}
