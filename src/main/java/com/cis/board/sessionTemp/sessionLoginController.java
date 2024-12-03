package com.cis.board.sessionTemp;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class sessionLoginController {

    @GetMapping("/login")
    public String home(HttpSession session){

        //String userid = "asd";
        String adminid = "amd_01";
        String admpass = "123";

       // userdao userDao = new userdao();
        admdao admDao = new admdao();

        if(adminid.equals(admDao.getEmp_id())&&admpass.equals(admDao.getPassword())) {

            session.setAttribute("admId", admDao.getEmp_id());
            session.setAttribute("Name", admDao.getUsername());

            System.out.println("로그인완료");
        }else {

            session.invalidate();
            System.out.println("로그인 실패+");
        }

            return "redirect:/board_gj";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화

        return "redirect:/board_gj"; // 로그인 페이지로 리다이렉트
    }



}
