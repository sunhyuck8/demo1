package com.bhome.demo.dao;

import com.bhome.demo.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    List boardSelectAll();
    List boardSelectAllByType(String boardType,String subType);
    BoardDto boardDetail(int board_pk);
    void boardDelete(int board_pk);
    BoardDto boardUpdate(BoardDto boardDto);
    int boardRegist(BoardDto boardDto);

    List boardSelectAllByItem(String searchItem);
    List boardSelectAllByWriter(String writer);



}
