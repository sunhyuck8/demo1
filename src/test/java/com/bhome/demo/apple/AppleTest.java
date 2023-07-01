package com.bhome.demo.apple;

import com.bhome.demo.dao.AppleDAO;
import com.bhome.demo.dto.AppleMapperDTO;
import com.bhome.demo.service.ServiceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppleTest {
    @Autowired
    private ServiceTest serviceTest;
    @Autowired
    private AppleDAO appleDAO;

    @Test
    @DisplayName("apple테스트")
    public void testApple(){
        //given
        //when
        //then
        AppleMapperDTO appleMapperDTO = serviceTest.selectApple();

        Assertions.assertThat(appleMapperDTO.getName()).isEqualTo("test");
    }
}
