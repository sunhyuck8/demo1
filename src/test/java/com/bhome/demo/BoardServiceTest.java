package com.bhome.demo;

import com.bhome.demo.dto.BoardDto;
import com.bhome.demo.dto.BoardFilesDto;
import com.bhome.demo.dto.BoardNDto;
import com.bhome.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


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
        log.info("==list==>> {},{},{},{},{} ",list.get(0).getBoard_pk(),list.get(0).getBoard_title(),list.get(0).getUser_pk(),list.get(0).getBoardFileList().size());
        log.info("==list==>> {},{},{},{},{} ",list.get(1).getBoard_pk(),list.get(1).getBoard_title(),list.get(1).getUser_pk(),list.get(1).getBoardFileList().size());


    }

    @Test
    @DisplayName("boardService 테스트 selectAll (매개변수 있는경우)")
    void BoardSelectAll2(){
        List<BoardDto> list = boardService.boardSelectAll(1, 1);
        log.info("==list==>> {},{},{},{},{} ",list.get(0).getBoard_pk(),list.get(0).getBoard_title(),list.get(0).getUser_pk(),list.get(0).getBoardFileList().size());
        log.info("==list==>> {},{},{},{},{} ",list.get(1).getBoard_pk(),list.get(1).getBoard_title(),list.get(1).getUser_pk(),list.get(1).getBoardFileList().size());
        log.info("{}" ,list.size());
//        assertThat(list.get(0).getBoard_title()).isEqualTo("test1");
    }

    @Test
    @DisplayName("boardService테스트 detail")
    void detail(){
        BoardNDto board = boardService.boardDetail(1);
        log.info("boardDto {},{},{},{},{},{},{}",board.getBoard_pk(),
                board.getBoard_title(),
                board.getBoard_content(),
                board.getCategoryName(),
                board.getSubCategoryName(),
                board.getUser_pk(),
                board.getBoardFileList()
        );
    }

    @Test
    @DisplayName("boardService테스트 delete")
    void boardDelete(){
        int testBoard_pk = 7;

        boardService.boardDelete(testBoard_pk);

            boardService.boardDelete(testBoard_pk);
            log.info("완");
    }


    @Test
    @DisplayName("boardService 테스트 regist")
    void boardRegist() throws NoSuchFieldException, IllegalAccessException {

        List<BoardFilesDto> boardFileList = new ArrayList<BoardFilesDto>();
//        boardFileList.add(new BoardFilesDto(0, "orName1", "reName1", 100, 8));
//        boardFileList.add(new BoardFilesDto(0, "orName2", "reName2", 100, 8));
        BoardDto boardDto = new BoardDto(0,"test_title","test_content",1,1,1,boardFileList);
        //pk에 0을 넣고 테스트하지만 반환 값에서 pk가 정상적으로 들어온다.
        //Field객체로 pk를 먼저선언
//        Field pkField = boardDto.getClass().getDeclaredField("board_pk");
//        pkField.setAccessible(true);
//        pkField.set(boardDto,51);
//        log.info("list 레코드수는 ={}",boardFileList.size());
//        log.info("list 제목은 ={}, {}",boardFileList.get(1).getBoardFiles_oriName(),boardFileList.get(0).getBoardFiles_oriName());
        int result =0;
        result = boardService.boardRegist(boardDto);

        log.info("변화된 레코드수는 ={}",result);
    }

    @Test
    @DisplayName("boardService 테스트 update")
    void boardUpdate(){
        List<BoardFilesDto> list = new ArrayList<BoardFilesDto>();
        BoardDto board = new BoardDto(1, "제목1", "내용1", 1, 1, 1, list);

        int result = 0;
        result = boardService.boardUpdate(board);
        log.info("변화된 row수는 ={}",result);
    }


    @Test
    @DisplayName("boardService 테스트 selectByitem")
    void boardSelectAllByItem(){
        List<BoardDto> list = boardService.boardSelectAllByItem("내용");
        log.info("==list==>> {},size ={},filesize= {},{},{} ",list.get(0).getBoard_pk(),list.size(),list.get(0).getBoardFileList().size());

    }
}
