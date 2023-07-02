package com.bhome.demo;

import com.bhome.demo.dto.BoardDto;
import com.bhome.demo.dto.BoardNDto;
import com.bhome.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
//@ExtendWith(MockitoExtension.class)
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

    @Test
    @DisplayName("boardService테스트 detail")
    void detail(){
        BoardNDto board = boardService.boardDetail(1);
        log.info("디테일 {},  {}",board.getCategoryName(), board.getSubCategoryName());
    }

    @Test
    @DisplayName("boardService테스트 delete")
    void boardDelete(){
        int testBoard_pk = 7;

        boardService.boardDelete(testBoard_pk);

            boardService.boardDelete(testBoard_pk);
            log.info("완");

    }
}
