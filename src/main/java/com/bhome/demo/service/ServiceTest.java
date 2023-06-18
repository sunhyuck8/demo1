package com.bhome.demo.service;

import com.bhome.demo.dao.AppleDAO;
import com.bhome.demo.dto.AppleMapperDTO;
import org.springframework.stereotype.Service;

@Service
public class ServiceTest {
    private final AppleDAO appleDAO;

    public ServiceTest(AppleDAO appleDAO) {
        this.appleDAO = appleDAO;
    }


    public AppleMapperDTO selectApple(){
        return appleDAO.selectApple();
    }
}
