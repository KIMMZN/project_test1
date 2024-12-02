package com.cis.board.controller;

import com.cis.board.repository.IF_Reopository;
import com.cis.board.service.IF_board_service;
import com.cis.board.vo.commentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final IF_board_service ifboardservice;
    //댓글 insert
    @PostMapping(value = "/board/addComment/{num}")
    public Map<String, Object> addComment (@ModelAttribute commentVO commentvo)throws Exception {

        System.out.println("comentvo확인 ://");
        System.out.println(commentvo.toString());

        boolean success = false;
        try {
            success = ifboardservice.addCommentOne(commentvo);
            System.out.println(success+"  :boolean 확인");

        }catch (Exception e) {
            e.printStackTrace();
            success = false;
        }

        //응답
//        boolean success = false; // 초기값 설정
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        System.out.println(response+ "response확인");

        return response;
    }

    //댓글 view
    @GetMapping(value = "/board/getComment/{category}/{num}")
    public Map<String, Object> viewComment (@PathVariable String category, @PathVariable Integer num)throws Exception {

        boolean success = false;

        System.out.println(category + " // " + num);


        //paramters
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("board_num", num);
        System.out.println(params+ "  :params 확인");

        //return
        List<commentVO> comments = ifboardservice.viewComment(params);




//        returunList.forEach(comment -> {
//            // 대댓글 추가 로직
//            List<commentVO> replies = ifboardservice.getReplies(comment.getId());
//            comment.setReplies(replies);
//
//        });
        // 각 댓글에 작성자 여부 플래그 추가
//        comments.forEach(comment -> {
//            comment.setOwner(comment.getEmp_id().equals(currentUserId));
//
//        });

        for (commentVO commentVO : comments) {
            System.out.println("commentvo 확인");
            System.out.println(commentVO.toString());
        }



        Map<String, Object> response = new HashMap<>();
        response.put("comments", comments);
        response.put("success", true);
//        -----------------------------------
        // 로그인된 사용자 ID 가져오기 (예시: 세션 사용)
        String currentUserId = "asd";

        //임시아이디 부여
        if (currentUserId != null || !currentUserId.isEmpty()) {
            response.put("current_user_id", currentUserId);
        }
        System.out.println("확인"+ comments.size() + "/ "+ true);
// ---------------------------------------------------


        return response;
    }

    @DeleteMapping(value = "/board/deleteComment/{category}/{commentId}")
    public Map<String, Object> deleteComment(@PathVariable String category,
                                             @PathVariable Integer commentId) {
        boolean success = false;

        // 카테고리와 댓글 comment_num과 category로 삭제 처리

        //임시 아디 부여 .. 세션 활욯애야됨
        String currentUserId = "asd";

        try {
            //댓글 가져오기
            System.out.println("1");
            Map<String, Object> paramsOne = new HashMap<>();
            paramsOne.put("category", category);
            paramsOne.put("comment_num", commentId);
            commentVO commentvo = ifboardservice.getCmtByparamsOne(paramsOne);
            //if(comment)

            // 작성자 확인 후 삭제
            if (commentvo.getEmp_id().equals(currentUserId)) {
                Map<String, Object> params = new HashMap<>();
                params.put("category", category);
                params.put("comment_num", commentId);
                System.out.println("2");

                success = ifboardservice.deleteCommentByCategoryAndId(params);
            } else {
                System.out.println("삭제 권한 없음");
            }

        } catch (Exception e) {
            System.out.println("3");
            e.printStackTrace();
            success = false;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", success ? "댓글이 삭제되었습니다." : "댓글 삭제에 실패했습니다.");
        return response;
    }


}
