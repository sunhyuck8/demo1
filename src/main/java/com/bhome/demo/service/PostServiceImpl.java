package com.bhome.demo.service;

import com.bhome.demo.dto.PostDetailDtoo;
import com.bhome.demo.dto.PostDetailtDto;
import com.bhome.demo.dto.PostFormRegistDto;
import com.bhome.demo.dto.Post_files;
import com.bhome.demo.mapper.PostMapper;
import com.bhome.demo.util.FileManager;
import com.bhome.demo.vo.PostDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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
    public int registPost(PostFormRegistDto postFormRegistDto) throws IOException {
        //글 내용저장
        postMapper.registPost(postFormRegistDto);
        int post_pk = postFormRegistDto.getPost_pk();
        log.info("service단 post_pk = {}",postFormRegistDto.getPost_pk());
        //postFormRegistDto에서 multipartList 저장하기
        List list_file_inputDB = new ArrayList();
        List post_files = postFormRegistDto.getPost_files();
        if(post_files.size()==0){
            Post_files postFiles = new Post_files("", "noimg.png", 0, post_pk);
            list_file_inputDB.add(postFiles);
        }else{
            for(Object post_file : post_files){
                MultipartFile file = (MultipartFile) post_file;
                String reFileName = fileManager.saveFileAndReturnFileName(file);
                Post_files postFiles = new Post_files(file.getOriginalFilename(), reFileName, file.getSize(), post_pk);
                list_file_inputDB.add(postFiles);
            }
        }
        postMapper.registPostFiles(list_file_inputDB);
        return post_pk;


    }


    @Override
    public PostDetailVo showDetailPost(int post_pk) {
        PostDetailDtoo postDetailDto = new PostDetailDtoo();
        postDetailDto = postMapper.showDetailPost(post_pk);
        log.info("serviceImple {}", postDetailDto);
        PostDetailVo postDetailVo = new PostDetailVo(
                postDetailDto.getPost_pk(),
                postDetailDto.getPost_title(),
                postDetailDto.getPost_content(),
                postDetailDto.getPost_category_name(),
                postDetailDto.getPost_subcategory_name(),
                postDetailDto.getUser_name(),
                postDetailDto.getUsers_pk(),
                postDetailDto.getPost_createdAt(),
                postDetailDto.getPost_files()
        );

        return postDetailVo;
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
