package com.bhome.demo.service;

import com.bhome.demo.dto.UserDto;
import com.bhome.demo.dto.UserLoginDto;
import com.bhome.demo.dto.UserRegistDto;
import com.bhome.demo.vo.UserVo;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface UserService {

    void userRegistInfo(UserRegistDto userRegistDto) throws IOException;//회원가입

    UserVo userLogin(UserLoginDto userLoginDto);
    
    int userRegist(UserDto userDto);  //삭제 대기

//    UserDto userGetInfo(UserDto userDto);

    int userUpdateInfo(UserDto userDto);

    String userDelete(int user_pk);

    //비밀번호 찾기, 아이디 찾기 추가
}
