package com.bhome.demo.service;

import com.bhome.demo.dto.PostFormRegistDto;
import com.bhome.demo.mapper.PostMapper;
import com.bhome.demo.util.FileManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService{
    private PostMapper postMapper;
    private FileManager fileManager;
    public PostServiceImpl(PostMapper postMapper, FileManager fileManager) {
        this.postMapper = postMapper;
        this.fileManager = fileManager;
    }

    @Override
    public List getSubList(String categoryName) {
        return postMapper.getSubCategoryList(categoryName);
    }

    @Override
    public int registPost(PostFormRegistDto postFormRegistDto) {
        int post_pk = postMapper.registPost(postFormRegistDto);
        //글 내용저장

        //postFormRegistDto에서 multipartList 저장하기


        return post_pk;
    }

    @Override
    public List selectAllPost() {
        return null;
    }

    @Override
    public List selectAllPost(int category_id) {
        return null;
    }

    @Override
    public List selectAllPost(String searchItem) {
        return null;
    }

    @Override
    public List selectAllPost(int category_id, String searchItem) {
        return null;
    }

    @Override
    public int updatePost(PostFormRegistDto postFormRegistDto) {
        return 0;
    }

    @Override
    public void deletePost(int post_pk) {

    }

    @Override
    public int postViewCnt(int post_pk) {
        return 0;
    }
}
