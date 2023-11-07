package com.bhome.demo.service;

import com.bhome.demo.dto.PostFormRegistDto;
import com.bhome.demo.vo.PostDetailVo;

import java.io.IOException;
import java.util.List;

public interface PostService {
    public List getSubList(String categoryName); //소카테고리 리스트 보여주기

    public int registPost(PostFormRegistDto postFormRegistDto) throws IOException;//post 저장하기

    public List selectAllPost();//postList보여주기

    public List selectAllPost(int category_id);//postList보여주기(카테고리별로)

    public List selectAllPost(String searchItem);//postList보여주기(searchItem별로)

    public List selectAllPost(int category_id ,String searchItem);//postList보여주기(searchItem별, 카테고리별)

    public int updatePost(PostFormRegistDto postFormRegistDto);//post 수정하기

    public void deletePost(int post_pk);//post 삭제하기

    public int postViewCnt(int post_pk);//post 조회수

    public PostDetailVo showDetailPost(int post_pk);
}
