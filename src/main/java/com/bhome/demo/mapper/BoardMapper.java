package com.bhome.demo.mapper;

import com.bhome.demo.dto.BoardDto;
import com.bhome.demo.dto.BoardFilesDto;
import com.bhome.demo.dto.BoardNDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> boardSelectAll();
    List<BoardDto> boardSelectAllByType(@Param("board_categoryNum") int boardType, @Param("board_subCategoryNum") int subType);
    BoardNDto boardDetail(int board_pk);
    void boardDelete(int board_pk);
    int boardUpdate(BoardDto boardDto);
    int boardRegist(BoardDto boardDto);

    int boardRegistFiles(List<BoardFilesDto> list);

    List<BoardDto> boardSelectAllByItem(String searchItem);
    List boardSelectAllByWriter(String writer);
}
