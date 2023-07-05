package com.bhome.demo.service;

import com.bhome.demo.dto.BoardDto;
import com.bhome.demo.dto.BoardNDto;

import java.util.List;

public interface BoardService {
    public List<BoardDto> boardSelectAll(); //모든 게시물 확인하기
    public List<BoardDto> boardSelectAll(int boardType, int subType);  //게시판별 특정타입 게시물보기

    public BoardNDto boardDetail(int board_pk);//상세보기

    public void boardDelete(int board_pk);//삭제하기

    public int boardUpdate(BoardDto boardDto);//수정하기

    public int boardRegist(BoardDto boardDto);//등록하기

    /*==찾기==*/
    public List boardSelectAllByItem(String searchItme);//아이템별 찾기
    public List boardSelectAllByWriter(String writer);//아이템별 찾기//작성자별 찾기


}
