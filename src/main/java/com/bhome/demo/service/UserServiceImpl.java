package com.bhome.demo.service;

import com.bhome.demo.dto.UserDto;
import com.bhome.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    public final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    @Override
    public int userRegist(UserDto userDto) {
        return userMapper.userRegist(userDto);
    }

    @Override
    public UserDto userGetInfo(UserDto userDto) {
        return userMapper.userLogin(userDto);
    }

    @Override
    public int userUpdateInfo(UserDto userDto) {
        return userMapper.userUpdateInfo(userDto);
    }

    @Override
    public String userDelete(int user_pk) {
        return userMapper.userDelete(user_pk);
    }
}
