package com.bhome.demo.service;

import com.bhome.demo.dto.UserDto;

public interface UserService {
    int userRegist(UserDto userDto);

    UserDto userGetInfo(UserDto userDto);

    int userUpdateInfo(UserDto userDto);

    String userDelete(int user_pk);

    //비밀번호 찾기, 아이디 찾기 추가
}
