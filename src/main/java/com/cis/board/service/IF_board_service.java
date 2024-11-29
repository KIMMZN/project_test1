package com.cis.board.service;



import com.cis.Pagination;
import com.cis.board.paging.PagingResponse;
import com.cis.board.vo.boardVO;
import com.cis.board.vo.fileVO;
import com.cis.board.vo.searchDTO;

import java.util.List;

public interface IF_board_service {
    //게시글 작성
   // public void writeOne(boardVO boardvo)throws Exception;
    //게시글작성 // 파일첨부 포함
    public void writeOneF(boardVO boardvo, List<fileVO> fileList)throws Exception;

    //
    public List<boardVO> viewAll()throws Exception;
    //조회수
    public void readBoard(int num)throws Exception;
    //공지사항 게시글보기
    public boardVO viewOne(int num)throws Exception;
    //자유 게시판게시글보기
    public boardVO viewOne_fr(int num)throws Exception;
    //선택 게시글 삭제
    public void delOne(int number)throws Exception;
    //선택 게시글삭제 new
    public void deleteOne(boardVO boardvo)throws Exception;
    //선택 게시글 선택 삭제
    public void modOne(boardVO boardvo)throws Exception;
    // 공지사항 게시글 리스트 조회 // param - searchDTO // return- 게시글 리스트(boardVO)
    public PagingResponse<boardVO> findAllPost(searchDTO params)throws Exception;

    // 자유게시판 게시글 리스트 조회 // param - searchDTO // return- 게시글 리스트(boardVO)
    public PagingResponse<boardVO> findAllPost_fr(searchDTO params)throws Exception;


}
