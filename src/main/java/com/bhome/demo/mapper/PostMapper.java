package com.bhome.demo.mapper;

import com.bhome.demo.dto.PostDetailDtoo;
import com.bhome.demo.dto.PostDetailtDto;
import com.bhome.demo.dto.PostFormRegistDto;
import com.bhome.demo.dto.Post_files;
import com.bhome.demo.vo.PostDetailVo;
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

    void registPostFiles(List<Post_files> files);// Post의 files db에 저장하기

    PostDetailDtoo showDetailPost(int post_pk);
    List selectAllPost();   //Post List 가져오기 조건 x



}
