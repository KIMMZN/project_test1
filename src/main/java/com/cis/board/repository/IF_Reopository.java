package com.cis.board.repository;


import com.cis.board.vo.boardVO;
import com.cis.board.vo.searchDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface IF_Reopository {
    public abstract void insertOne(boardVO boardvo) throws Exception;
    public List<boardVO> listAll() throws Exception;

    public void updateHits(int num)throws Exception;
    //게시글 보기
    public boardVO selectOne(int num)throws Exception;
    //삭제
    public void deleteOne(int number)throws Exception;
    //new 삭제

    public void deleteOnE(boardVO boardvo)throws Exception;

    //게시글 하나 수정
    public void updateOne(boardVO boardvo)throws Exception;
    //ifrepository.updateOne(boardvo);

    // 게시글 리스트 조회// search dto를 파라미터로,
    // return 게시글 리스트 - boardVO//
    List<boardVO> fiandAll(searchDTO parmas) throws Exception;

    // 게시글 수 카운팅
    //return 게시글수, 타입 int
    //파라미터는 searchDTO
     int count(searchDTO parmas)throws Exception;


}
