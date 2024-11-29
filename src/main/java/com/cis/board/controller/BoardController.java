package com.cis.board.controller;

import com.cis.board.paging.Pagination;
import com.cis.board.paging.PagingResponse;
import com.cis.board.service.IF_board_service;
import com.cis.board.util.FIleDataUtil;
import com.cis.board.vo.boardVO;
import com.cis.board.vo.fileVO;
import com.cis.board.vo.searchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final IF_board_service ifboardservice;
    private final FIleDataUtil filedatautil;


    @GetMapping(value = "/board_gj")
    public String board(@ModelAttribute searchDTO params,Model model)throws Exception {

        PagingResponse<boardVO> boardvolist = ifboardservice.findAllPost(params);

        //List<boardVO> boardvolist = ifboardservice.findAllPost(params);

        //boardvolist.getPagination().getStartPage()
        //현재 검색 조건과 페이징 정보 추가
        model.addAttribute("boardvolist", boardvolist);
        model.addAttribute("keyword", params.getKeyword());
        model.addAttribute("searchType", params.getSearchType());

        // model.addAttribute("boardvolist", boardvolist);
        // System.out.println(boardvolist.size()+ boardvolist.toString());
        //System.out.println(boardvolist);
        // 현재 페이지 추가
        model.addAttribute("currentPage", params.getPage());
        return "/board/board_gj";

    }
    //페이징을 위한 임시//
//    @GetMapping(value = "/board/home")
//    public String boardTemp (@ModelAttribute searchDTO params, Model model)throws Exception {
//
//        PagingResponse<boardVO> boardvolist = ifboardservice.findAllPost(params);
//
//        //List<boardVO> boardvolist = ifboardservice.findAllPost(params);
//
//        //boardvolist.getPagination().getStartPage()
//        //현재 검색 조건과 페이징 정보 추가
//        model.addAttribute("boardvolist", boardvolist);
//        model.addAttribute("keyword", params.getKeyword());
//        model.addAttribute("searchType", params.getSearchType());
//
//       // model.addAttribute("boardvolist", boardvolist);
//        // System.out.println(boardvolist.size()+ boardvolist.toString());
//        //System.out.println(boardvolist);
//        // 현재 페이지 추가
//        model.addAttribute("currentPage", params.getPage());
//        return "/board/board_temp";
//
//    }


    @GetMapping(value = "/write_gj")
    public String write_gj()throws Exception {




        return "/board/write_gj";
    }

    //글쓰기
    @PostMapping(value = "/board_write_one")
    public String board_write_one(@ModelAttribute boardVO boardvo,
                                  @RequestParam(value = "file") List<MultipartFile> file)throws Exception {
//
        //파일 경로에 저장 하고 새로운 파일 이름 리턴
        List<fileVO> fileVoList= filedatautil.savefiles(file);


        //변경된 파일이름 리턴
        for (fileVO fileName : fileVoList) {
            System.out.println(fileName + "   //파일네임테스트");
        }

        //boardvo에 첨부된 파일 갯수를 저장
        boardvo.setFileAttached(filedatautil.attaced(file));

        //글쓰기 서비스단 call
        ifboardservice.writeOneF(boardvo, fileVoList);
        //서비스 call
        //ifboardservice.writeOne(boardvo, filevoe);
        //ifboardservice.writeOne(boardvo);

        //리다이렉트 처리
        if(boardvo.getCategory().equals("공지사항")) {
            return "redirect:/board_gj";
        }else {
            return "redirect:/board_fr";
        }

    }




//    @GetMapping(value = "/board_fr")
//    public String board_fr(Model model)throws Exception {
//
//        return "/board/board_fr";
//    }
        @GetMapping(value = "/board_fr")
        public String board_fr(@ModelAttribute searchDTO params,Model model)throws Exception {

            PagingResponse<boardVO> boardvolist = ifboardservice.findAllPost_fr(params);

            //List<boardVO> boardvolist = ifboardservice.findAllPost(params);

            //boardvolist.getPagination().getStartPage()
            //현재 검색 조건과 페이징 정보 추가
            model.addAttribute("boardvolist", boardvolist);
            model.addAttribute("keyword", params.getKeyword());
            model.addAttribute("searchType", params.getSearchType());

            // model.addAttribute("boardvolist", boardvolist);
            // System.out.println(boardvolist.size()+ boardvolist.toString());
            //System.out.println(boardvolist);
            // 현재 페이지 추가
            model.addAttribute("currentPage", params.getPage());


             return "/board/board_fr";
        }



    @GetMapping(value = "/write_fr")
    public String write_fr()throws Exception {




        return "/board/write_fr";
    }

    //공지사항 글 하나 보기
    @GetMapping(value = "/gj_preview/{board_num}")
    public String gj_preview(@PathVariable("board_num") int num, Model model)throws Exception {
        System.out.println(num + "  게시글넘버");
        //조회수
        ifboardservice.readBoard(num);
        //내용 옮기기 //
        boardVO boardvo = ifboardservice.viewOne(num);
        model.addAttribute("boardvo", boardvo);
        System.out.println(boardvo.toString() + "boardvo");
        return "/board/gj_preview";
    }


    //자유게시판 글 보기
    @GetMapping(value = "/fr_preview/{board_num}")
    public String fr_preview(@PathVariable("board_num") int num, Model model)throws Exception {
        System.out.println(num + "  게시글넘버");
        //조회수
        ifboardservice.readBoard(num);
        //내용 옮기기
        boardVO boardvo = ifboardservice.viewOne_fr(num);


        model.addAttribute("boardvo", boardvo);
        System.out.println(boardvo.toString() + "boardvo");
        return "/board/fr_preview";
    }

    //글 삭제 (num,category)
    @PostMapping(value = "/gj_preview/delOne/{num}")
    public String gj_preview_delOne(@PathVariable("num") int num,@ModelAttribute boardVO boardvo)throws Exception {
        boardvo.setBoard_num(num);
        
        //System.out.println(boardvo.toString()+"   !!!!tostiong 테스트");

        ifboardservice.deleteOne(boardvo);
        //System.out.println(boardvo.getCategory() + "카테고리");
        //System.out.println(num+"게시글넘버");


        return "redirect:/board_gj";
    };

    //공지게시판 수정
    @PostMapping(value = "/gj_preview/modifyOne/{num}")
    public String gj_modifyOne(@ModelAttribute boardVO boardvo)throws Exception {



        ifboardservice.modOne(boardvo);
        //System.out.println(num + "     a asdf");
        System.out.println(boardvo.toString()+"   boardvo테스트");

        return "redirect:/board_gj";
    }

    //자유게시판 수정
    @PostMapping(value = "/fr_preview/modifyOne/{num}")
    public String fr_modifyOne(@ModelAttribute boardVO boardvo)throws Exception {



        ifboardservice.modOne(boardvo);
        //System.out.println(num + "     a asdf");
        System.out.println(boardvo.toString()+"   boardvo테스트");

        return "redirect:/board_fr";
    }




}
