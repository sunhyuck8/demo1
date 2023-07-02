package com.bhome.demo.service;

import com.bhome.demo.dto.BoardDto;
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
    public BoardDto boardUpdate(BoardDto boardDto) {
        return null;
    }

    @Override
    public int boardRegist(BoardDto boardDto) {
        return 0;
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
