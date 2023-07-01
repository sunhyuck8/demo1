package com.bhome.demo.mapper;

import com.bhome.demo.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> boardSelectAll();
    List<BoardDto> boardSelectAllByType(@Param("board_categoryNum") int boardType, @Param("board_subCategoryNum") int subType);
    BoardDto boardDetail(int board_pk);
    void boardDelete(int board_pk);
    BoardDto boardUpdate(BoardDto boardDto);
    int boardRegist(BoardDto boardDto);

    List boardSelectAllByItem(String searchItem);
    List boardSelectAllByWriter(String writer);
}
