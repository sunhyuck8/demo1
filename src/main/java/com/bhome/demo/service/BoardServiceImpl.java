package com.bhome.demo.service;

import com.bhome.demo.dto.BoardDto;
import com.bhome.demo.dto.BoardFilesDto;
import com.bhome.demo.dto.BoardNDto;
import com.bhome.demo.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    @Override
    public List<BoardDto> boardSelectAll() {
        return new ArrayList<>(boardMapper.boardSelectAll());
    }

    @Override
    public List<BoardDto> boardSelectAll(int boardType, int subType) {
        return new ArrayList<>(boardMapper.boardSelectAllByType(boardType,subType));
    }

    @Override
    public BoardNDto boardDetail(int board_pk) {
        System.out.println(boardMapper.boardDetail(board_pk).toString());
        return boardMapper.boardDetail(board_pk);
    }

    @Override
    public void boardDelete(int board_pk) {
        boardMapper.boardDelete(board_pk);
    }

    @Override
    public int boardUpdate(BoardDto boardDto) {
        return boardMapper.boardUpdate(boardDto);
    }

    @Override
    public int boardRegist(BoardDto boardDto) {

        int result =boardMapper.boardRegist(boardDto);
        int board_pk=boardDto.getBoard_pk();
        List<BoardFilesDto> list= boardDto.getBoardFileList();
        if(list.size()==0||list==null){
            return result;
        }else{
            int result2 = boardMapper.boardRegistFiles(list);
            return result2;
        }
    }

    @Override
    public List boardSelectAllByItem(String itme) {
        return null;
    }

    @Override
    public List boardSelectAllByWriter(String writer) {
        return null;
    }
}
