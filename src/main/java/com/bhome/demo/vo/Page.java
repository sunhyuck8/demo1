package com.bhome.demo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public class Page {
    private List list;
    private int totalRecord;
    private int currentPage;
    private int pageSize;
    private int totalPage;
    private int currentBlockSize;
    private int minBlock;
    private int addBlock;

    public Page(){

    }


}
