package com.bhome.demo;

import com.bhome.demo.dto.BoardDto;
import com.bhome.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
public class BoardServiceTest {

    @Autowired
    BoardService boardService;


    @Test
    @DisplayName("boardServce 테스트 selectAll")
    void BoardSelectAll(){
        List<BoardDto> list = boardService.boardSelectAll();
        log.info("BoardSelectAll 테스트더미컬럼 사이즈"+list.get(0).getBoardFileList().size());

        assertThat(list.get(0).getBoardFileList().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("boardService 테스트 selectAll (매개변수 있는경우)")
    void BoardSelectAll2(){
        List<BoardDto> list = boardService.boardSelectAll(1, 2);
        log.info("BoardSelectAll2 테스트더미컬럼 사이즈=={}개",list.get(0).getBoard_title());
        assertThat(list.get(0).getBoard_title()).isEqualTo("test1");
    }



}
