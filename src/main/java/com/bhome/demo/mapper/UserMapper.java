package com.bhome.demo.mapper;

import com.bhome.demo.dto.UserDto;
import com.bhome.demo.dto.UserFileDto;
import com.bhome.demo.dto.UserLoginDto;
import com.bhome.demo.dto.UserRegistDto;
import com.bhome.demo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userRegist(UserDto userDto);

    int usersRegistInfo(UserRegistDto userRegistDto);

    int usersRegistPhoto(UserFileDto userFileDto);

    UserVo userLogin(UserLoginDto userLoginDto);

    int userUpdateInfo(UserDto userDto);

    String userDelete(int user_pk);


}
