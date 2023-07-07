package com.bhome.demo.mapper;

import com.bhome.demo.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userRegist(UserDto userDto);

    UserDto userLogin(UserDto userDto);

    int userUpdateInfo(UserDto userDto);

    String userDelete(int user_pk);

}
