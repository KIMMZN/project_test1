package com.cis.board.controller;

import com.cis.board.paging.Pagination;
import com.cis.board.paging.PagingResponse;
import com.cis.board.service.IF_board_service;
import com.cis.board.vo.boardVO;
import com.cis.board.vo.searchDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class Board_Manager_Controller {

    private final IF_board_service ifboardservice;


    @GetMapping(value = "/board/manager")
    public String board_fr(@ModelAttribute searchDTO params, Model model,
                           HttpSession session) throws Exception {
        System.out.println("--------------");
        System.out.println(params.toString()+"   //search Dto확인");
        System.out.println("--------------");
        String emp_name = "";
        if(session.getAttribute("employee_id") != null) {
            System.out.println("자유게시판!!");
            System.out.println(session.getAttribute("emp_name") + "  //유저네임");
            System.out.println(session.getAttribute("employee_id") + "   /아이디");
            System.out.println(session.getAttribute("emp_rank") + "  //랭크");

            String emp_id = (String) session.getAttribute("employee_id");
            emp_name = (String) session.getAttribute("emp_name");
            String rank = (String) session.getAttribute("emp_rank");

            model.addAttribute("emp_id", emp_id);
            model.addAttribute("emp_name", emp_name);
            model.addAttribute("rank", rank);
        }
        //
        PagingResponse<boardVO> boardvolist = ifboardservice.findAllPost_adm(params);
//        PagingResponse<boardVO> boardvolist = ifboardservice.findAllPost_fr(params);
//        PagingResponse<boardVO> boardvolist = ifboardservice.findAllPost_Adm(params);
        // Null 체크 및 기본값 설정
        if (boardvolist == null || boardvolist.getList() == null) {
            boardvolist = new PagingResponse<>();
            boardvolist.setList(new ArrayList<>()); // 빈 리스트로 초기화
            boardvolist.setPagination(new Pagination(1, params)); // 페이징 정보 기본값
        }

        //확인요망. 공지게시판에서는 viewone 메서드 써야될듯
        for (boardVO boardvo : boardvolist.getList()) {
//            boardVO boardvoo= ifboardservice.viewOne_fr(boardvo.getBoard_num());
            //board테이블의 id를 param으로 보내고 멤버 테이블에서 이름을 return 받는다.
            emp_name = ifboardservice.getNameById(boardvo.getEmp_id());
            System.out.println(ifboardservice.getNameById(boardvo.getEmp_id()));
            //예외 처리
            if (emp_name == null){
                emp_name = "";
            }
            boardvo.setEmp_id(emp_name);

        }



        for(boardVO boardvo : boardvolist.getList()) {
            System.out.println(boardvo.toString());
        }

        //boardvolist.getPagination().getStartPage()
        //현재 검색 조건과 페이징 정보 추가
        model.addAttribute("boardvolist", boardvolist);
        model.addAttribute("keyword", params.getKeyword());
        model.addAttribute("searchType", params.getSearchType());

        model.addAttribute("currentPage", params.getPage());

        return "board/board_mng/board_fr";
    }



}
