package com.cis.board.service;


import com.cis.board.paging.Pagination;
import com.cis.board.paging.PagingResponse;
import com.cis.board.repository.IF_Reopository;
import com.cis.board.vo.boardVO;
import com.cis.board.vo.searchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class board_service_Impl implements IF_board_service {


     private final IF_Reopository ifrepository;


    @Override
    public void writeOne(boardVO boardvo) throws Exception {

                ifrepository.insertOne(boardvo);

    }

    //공지 all
    @Override
    public List<boardVO> viewAll() throws Exception {


        List<boardVO> lista = ifrepository.listAll();
        System.out.println(lista + "서비스단 리스트 확인");
        return lista;
    }
    //자유게시판 all
    
    //하나보기
    @Override
    public void readBoard(int num) throws Exception {

        ifrepository.updateHits(num);

    }
    //선택 게시글 보기
    @Override
    public boardVO viewOne(int num) throws Exception {

        return ifrepository.selectOne(num);
    }

    //삭제
    @Override
    public void delOne(int number) throws Exception {

        ifrepository.deleteOne(number);
    }

    @Override
    public void deleteOne(boardVO boardvo) throws Exception {

        ifrepository.deleteOnE(boardvo);
    }


    //수정
    @Override
    public void modOne(boardVO boardvo) throws Exception {

        ifrepository.updateOne(boardvo);
    }

    //게시글 리스트 조회
    // param - searchDTO
    // return - 게시글 리스트(List<boardVO>)
    @Override
    public PagingResponse<boardVO> findAllPost(searchDTO params) throws Exception {
        //조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와
        //null을 담아 반환
        int count = ifrepository.count(params);
        if(count<1) {
            //데이터가 없는 경우에 pagination 객체 생성
            Pagination emtypagination = new Pagination(0,params);// totalrecordcount = 0;
            params.setPagination(emtypagination);
            
            //빈 pagination 객체 생성
            return new PagingResponse<>(Collections.emptyList(), emtypagination);
            
        }
        
        //데이터가 있는 경우 Pagination 생성
        // Paginaton 객체를 생성해서 페이지 정보 계산 후 searchDTO 타입의 객체인
        // params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);
        
        //조회
        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로
        // 리스트 데이터 조회 후 응답 데이터 반환
        List<boardVO> list = ifrepository.fiandAll(params);
        return new PagingResponse<>(list, pagination);

    }







}
