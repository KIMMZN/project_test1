package com.cis.board.controller;

import com.cis.board.paging.Pagination;
import com.cis.board.paging.PagingResponse;
import com.cis.board.service.IF_board_service;
import com.cis.board.util.FIleDataUtil;
import com.cis.board.vo.boardVO;
import com.cis.board.vo.fileVO;
import com.cis.board.vo.searchDTO;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final IF_board_service ifboardservice;
    private final FIleDataUtil filedatautil;


    @GetMapping(value = "/board_gj")
    public String board(@ModelAttribute searchDTO params, Model model) throws Exception {

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
    public String write_gj() throws Exception {


        return "/board/write_gj";
    }

    //글쓰기
    @PostMapping(value = "/board_write_one")
    public String board_write_one(@ModelAttribute boardVO boardvo,
                                  @RequestParam(value = "file", required = false) List<MultipartFile> file) throws Exception {
//

        // 파일이 null이면 빈 리스트로 초기화
        if (file == null) {
            file = new ArrayList<>();
        }

        //파일 경로에 저장 하고 새로운 파일 이름 리턴
        List<fileVO> fileVoList = filedatautil.savefiles(file);
        //boardvo에 첨부된 파일 갯수를 저장
        boardvo.setFileAttached(filedatautil.attaced(file));
//            ifboardservice.writeOne(boardvo);

        ifboardservice.writeOneF(boardvo, fileVoList);

        //리다이렉트 처리
        if (boardvo.getCategory().equals("공지사항")) {
            return "redirect:/board_gj";
        } else {
            return "redirect:/board_fr";
        }

    }

    @GetMapping(value = "/board_fr")
    public String board_fr(@ModelAttribute searchDTO params, Model model) throws Exception {

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
    public String write_fr() throws Exception {


        return "/board/write_fr";
    }

    //공지사항 글 하나 보기
    @GetMapping(value = "/gj_preview/{board_num}")
    public String gj_preview(@PathVariable("board_num") int num, Model model) throws Exception {
        System.out.println(num + "  게시글넘버");
        //조회수
        ifboardservice.readBoard(num);
        //내용 옮기기 //
        boardVO boardvo = ifboardservice.viewOne(num);
        model.addAttribute("boardvo", boardvo);
        System.out.println(boardvo.toString() + "boardvo");
        return "/board/gj_preview";
    }


    //자유게시판 글 보기 + file attached//
    @GetMapping(value = "/fr_preview/{board_num}")
    public String fr_preview(@PathVariable("board_num") int num, Model model) throws Exception {
        System.out.println(num + "  게시글넘버");
        //조회수
        ifboardservice.readBoard(num);
        //내용 옮기기
        boardVO boardvo = ifboardservice.viewOne_fr(num);
        //파일 테이블에서 사용할 카테고리 파라미터
        String categoryTemp = boardvo.getCategory();
        System.out.println("카테고리 테스트:  " + categoryTemp);
        //file board 가져오기
        List<fileVO> fileList = ifboardservice.getAttach(num, categoryTemp);
        //db에서 가져온값 확인
        for (fileVO file : fileList) {
            System.out.println(file.toString());
        }


        //model에 전송할 값들 추가
        model.addAttribute("boardvo", boardvo);
        model.addAttribute("fileList", fileList);
        System.out.println(boardvo.toString() + "boardvo");
        return "/board/fr_preview";
    }

    //글 삭제 (num,category)
    @PostMapping(value = "/gj_preview/delOne/{num}")
    public String gj_preview_delOne(@PathVariable("num") int num, @ModelAttribute boardVO boardvo) throws Exception {
        boardvo.setBoard_num(num);

        //System.out.println(boardvo.toString()+"   !!!!tostiong 테스트");

        ifboardservice.deleteOne(boardvo);
        //System.out.println(boardvo.getCategory() + "카테고리");
        //System.out.println(num+"게시글넘버");


        return "redirect:/board_gj";
    }

    ;

    //공지게시판 수정
    @PostMapping(value = "/gj_preview/modifyOne/{num}")
    public String gj_modifyOne(@ModelAttribute boardVO boardvo) throws Exception {


        ifboardservice.modOne(boardvo);
        //System.out.println(num + "     a asdf");
        System.out.println(boardvo.toString() + "   boardvo테스트");

        return "redirect:/board_gj";
    }

    //자유게시판 수정
    @PostMapping(value = "/fr_preview/modifyOne/{num}")
    public String fr_modifyOne(@ModelAttribute boardVO boardvo) throws Exception {


        ifboardservice.modOne(boardvo);
        //System.out.println(num + "     a asdf");
        System.out.println(boardvo.toString() + "   boardvo테스트");

        return "redirect:/board_fr";
    }

    //자유게시판 파일 다운로드
    // @GetMapping(value = "")

    @GetMapping(value = "/fr_preview/{board_num}/{file_num}/{category}")
    public ResponseEntity<org.springframework.core.io.Resource> downloadFile(
            @PathVariable("board_num") int boardNum,
            @PathVariable("file_num") int fileNum,
            @PathVariable("category") String category)throws Exception {

        try {
            // 데이터베이스에서 파일 정보 가져오기
            List<fileVO> fileInfoList = ifboardservice.getAttach(boardNum, category);

            if (fileInfoList == null || fileInfoList.isEmpty()) {
                return ResponseEntity.notFound().build(); // 파일 정보가 없으면 404 반환
            }

            // file_num과 일치하는 파일 찾기
            fileVO targetFile = fileInfoList.stream()
                    .filter(file -> file.getFile_id() == fileNum)
                    .findFirst()
                    .orElse(null);

            if (targetFile == null) {
                return ResponseEntity.notFound().build(); // 해당 file_num의 파일이 없으면 404 반환
            }

            // 파일 경로 생성
            File file = new File(filedatautil.getUploadDir() + "/" + targetFile.getSave_name());

            if (!file.exists()) {
                return ResponseEntity.notFound().build(); // 파일이 없으면 404 반환
            }

            // FileSystemResource 생성
            org.springframework.core.io.Resource resource = new org.springframework.core.io.FileSystemResource(file);

            // 파일 이름 인코딩 (한글 및 특수 문자 처리)
            String encodedFileName = java.net.URLEncoder.encode(targetFile.getOriginal_name(), "UTF-8").replaceAll("\\+", "%20");

            // 다운로드 가능한 ResponseEntity 반환
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFileName + "\"")
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build(); // 서버 오류 반환
        }

    }
}


