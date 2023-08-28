package com.bhome.demo.service;

import com.bhome.demo.dto.UserDto;
import com.bhome.demo.dto.UserFileDto;
import com.bhome.demo.dto.UserLoginDto;
import com.bhome.demo.dto.UserRegistDto;
import com.bhome.demo.mapper.UserMapper;
import com.bhome.demo.util.FileManager;
import com.bhome.demo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private FileManager fileManager;
    public final UserMapper userMapper;

    public UserServiceImpl(FileManager fileManager, UserMapper userMapper){
        this.fileManager = fileManager;
        this.userMapper=userMapper;
    }
    @Transactional
    @Override
    public void userRegistInfo(UserRegistDto userRegistDto) throws IOException {
        //정보 처리
        userMapper.usersRegistInfo(userRegistDto);
        int users_pk =userRegistDto.getUser_pk();

        if(!userRegistDto.getPhoto().isEmpty()){
            //사진업로드 처리
            MultipartFile photo = userRegistDto.getPhoto();
            String fileName = fileManager.saveFileAndReturnFileName(photo);
            UserFileDto userFileDto = new UserFileDto(photo.getOriginalFilename(),fileName,photo.getSize(),users_pk);
            int result_photo = userMapper.usersRegistPhoto(userFileDto);
        }else{
            UserFileDto userFileDto = new UserFileDto("","noimg.png",0l,users_pk);
            userMapper.usersRegistPhoto(userFileDto);
        }

    }

    @Override
    public UserVo userLogin(UserLoginDto userLoginDto) {

        return userMapper.userLogin(userLoginDto);
    }

    @Override
    public int userRegist(UserDto userDto) {
        return userMapper.userRegist(userDto);
    }

//    @Override
//    public UserDto userGetInfo(UserDto userDto) {
//        return userMapper.userLogin(userDto);
//    }

    @Override
    public int userUpdateInfo(UserDto userDto) {
        return userMapper.userUpdateInfo(userDto);
    }

    @Override
    public String userDelete(int user_pk) {
        return userMapper.userDelete(user_pk);
    }
}
