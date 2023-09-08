package com.bhome.demo.service;

import com.bhome.demo.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService{
    private PostMapper postMapper;
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List getSubList(String categoryName) {
//        log.info("리스트 개수 {}개",postMapper.getSubCategoryList(categoryName).get(1));
        return postMapper.getSubCategoryList(categoryName);
    }
}
