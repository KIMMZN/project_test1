package com.cis.board.service;


import com.cis.board.paging.Pagination;
import com.cis.board.paging.PagingResponse;
import com.cis.board.repository.IF_Reopository;
import com.cis.board.vo.boardVO;
import com.cis.board.vo.fileVO;
import com.cis.board.vo.searchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
public class board_service_Impl implements IF_board_service {


     private final IF_Reopository ifrepository;

    //게시글 작성, 공지사항글 자유게시판글 분리 //+file
//    @Override
//    public void writeOne(boardVO boardvo) throws Exception {
//
//                if(boardvo.getCategory().equals("공지사항")) {
//                    ifrepository.insertOne(boardvo);
//                }else {
//                    ifrepository.insertOne_fr(boardvo);
//                }
//
//
//    }

    @Override
    public void writeOneF(boardVO boardvo, List<fileVO> fileList) throws Exception {

        if(boardvo.getCategory().equals("공지사항")) {
            ifrepository.insertOne(boardvo);
        }else {
            ifrepository.insertOne_fr(boardvo);
        }

        //table에 insert된 board의 id가져오기
       String categoryTemp = boardvo.getCategory();
        int board_num_temp = ifrepository.getBoardNum(categoryTemp);
        System.out.println("보드넘 가져온 값 확인:  "+ board_num_temp);

        //file첨부, 게시판 id와 게시판 카테고리 추가하여
        if (!fileList.isEmpty() && fileList != null && boardvo.getFileAttached() != 0) {
                for (fileVO file : fileList) {
                    file.setBoard_num(board_num_temp);// 생성된 board_num 설정
                    file.setCategory(boardvo.getCategory()); // 카테고리 설정
                    ifrepository.insertFile(file);
//                }
                }
        }



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
    //공지사항 선택 게시글 보기
    @Override
    public boardVO viewOne(int num) throws Exception {
        //num으로 가져오니 에러

        return ifrepository.selectOne(num);
    }

    //자유게시판
    @Override
    public boardVO viewOne_fr(int num) throws Exception {

        return ifrepository.selectOne_fr(num);
    }

    @Override
    public List<fileVO> getAttach(int num,String category) throws Exception {
                //Map에 파일 파라미터 설정
                Map<String, Object> params = new HashMap<>();
                params.put("category", category);
                params.put("num", num);


        return ifrepository.selectFile(params);
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

    //공지사항 게시글 리스트 조회
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

    //자유게시판 게시글 리스트 조회
    // param - searchDTO
    // return - 게시글 리스트(List<boardVO>)
    @Override
    public PagingResponse<boardVO> findAllPost_fr(searchDTO params) throws Exception {
        //조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와
        //null을 담아 반환
        int count = ifrepository.count_fr(params);
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
        List<boardVO> list = ifrepository.fiandAll_fr(params);
        return new PagingResponse<>(list, pagination);


    }


}
