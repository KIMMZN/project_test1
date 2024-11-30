package com.cis.board.repository;


import com.cis.board.vo.boardVO;
import com.cis.board.vo.fileVO;
import com.cis.board.vo.searchDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;


@Mapper
public interface IF_Reopository {
    public abstract void insertOne(boardVO boardvo) throws Exception;
    public abstract void insertOne_fr(boardVO boardvo) throws Exception;
    public List<boardVO> listAll() throws Exception;

    public void updateHits(int num)throws Exception;
    //공지사항 게시글 보기
    public boardVO selectOne(int num)throws Exception;
    //자유게시판 게시글 보기
    public boardVO selectOne_fr(int num)throws Exception;
    //삭제
    public void deleteOne(int number)throws Exception;
    //new 삭제

    public void deleteOnE(boardVO boardvo)throws Exception;

    //게시글 하나 수정
    public void updateOne(boardVO boardvo)throws Exception;
    //ifrepository.updateOne(boardvo);

    // 공지사항 게시글 리스트 조회// search dto를 파라미터로,
    // return 게시글 리스트 - boardVO//
    List<boardVO> fiandAll(searchDTO parmas) throws Exception;


    // 공지사항 게시글 리스트 조회// search dto를 파라미터로,
    // return 게시글 리스트 - boardVO//
    List<boardVO> fiandAll_fr(searchDTO parmas) throws Exception;



    // 게시글 수 카운팅
    //return 게시글수, 타입 int
    //파라미터는 searchDTO
    int count(searchDTO parmas)throws Exception;

    // 게시글 수 카운팅
    //return 게시글수, 타입 int
    //파라미터는 searchDTO
     int count_fr(searchDTO parmas)throws Exception;

     //파일 저장
      public void insertFile(fileVO file)throws Exception;
     //board_num 가져오기
        public int getBoardNum(String categoryTemp)throws Exception;
        //자유게시판 파일 가져요기
         //List<fileVO> fileList = boardservice.getAttach(num);
        public List<fileVO> selectFile(Map<String, Object> params)throws Exception;



}
