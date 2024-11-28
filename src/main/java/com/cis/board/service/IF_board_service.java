package com.cis.board.service;



import com.cis.Pagination;
import com.cis.board.paging.PagingResponse;
import com.cis.board.vo.boardVO;
import com.cis.board.vo.searchDTO;

import java.util.List;

public interface IF_board_service {

    public void writeOne(boardVO boardvo)throws Exception;

    public List<boardVO> viewAll()throws Exception;
    //조회수
    public void readBoard(int num)throws Exception;
    //게시글보기
    public boardVO viewOne(int num)throws Exception;
    //선택 게시글 삭제
    public void delOne(int number)throws Exception;
    //선택 게시글삭제 new
    public void deleteOne(boardVO boardvo)throws Exception;
    //선택 게시글 선택 삭제
    public void modOne(boardVO boardvo)throws Exception;
    // 게시글 리스트 조회 // param - searchDTO // return- 게시글 리스트(boardVO)
    public PagingResponse<boardVO> findAllPost(searchDTO params)throws Exception;


}
