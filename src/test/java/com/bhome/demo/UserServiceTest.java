package com.bhome.demo;

import com.bhome.demo.dto.UserDto;
import com.bhome.demo.mapper.UserMapper;
import com.bhome.demo.service.UserServiceImpl;
import com.bhome.demo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserMapper userMapper;

    @Test
    @DisplayName("회원등록")
    void userRegist() {
//        when(mockObject.methodCall()).thenReturn(returnValue)
        when(userMapper.userRegist(any(UserDto.class))).thenReturn(1);
        UserDto userDto = new UserDto(0,"id","pass","name",3,"male","naver","hi",LocalDateTime.now(),LocalDateTime.now());

        int result = userService.userRegist(userDto);
        assertThat(result).isEqualTo(1);
        Mockito.verify(userMapper, Mockito.times(1)).userRegist(userDto);
    }

    @Test
    @DisplayName("회원로그인")
    void userLogin(){
        UserDto loginDto = new UserDto("test", "test");
        UserDto resultDto = new UserDto();
        when(userMapper.userLogin(loginDto)).thenReturn(resultDto);

        UserDto returnDto = userService.userGetInfo(loginDto);

        assertThat(resultDto).isEqualTo(returnDto);
    }
    @Test
    @DisplayName("회원정보수정")
    void userUpdateInfo() {
        UserDto updateDto = new UserDto(1, "test11","test11","dumy1",3,"male","as@com","안녕1");

        when(userMapper.userUpdateInfo(updateDto)).thenReturn(1);

        int result = userService.userUpdateInfo(updateDto);

        assertThat(result).isEqualTo(1);
        Mockito.verify(userMapper, Mockito.times(1)).userUpdateInfo(updateDto);
    }

    @Test
    @DisplayName("회원탈퇴")
    void userWithdraw(){
        UserDto delUserDto = new UserDto(1);
        when(userMapper.userDelete(delUserDto.getUser_pk())).thenReturn("탈퇴한 회원");

        String result = userService.userDelete(delUserDto.getUser_pk());

        assertThat(result).isEqualTo("탈퇴한 회원");
        Mockito.verify(userMapper, Mockito.times(1)).userDelete(delUserDto.getUser_pk());
    }
}
