package com.cis.member.controller;

import com.cis.member.dto.MemberDTO;
import com.cis.member.service.IF_MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@Validated
@RequiredArgsConstructor
//@RestController
public class MemberController {

    @Autowired
     IF_MemberService memberService;

    // 시작화면 (로그인 방식 선택.)
    @GetMapping(value="/")
    public String start_page() throws Exception{
        System.out.println("시작화면");
        return "Member/total_login";
    }

    // 사원 로그인 선택시
    @GetMapping(value="/employee_login")
    public String login() throws Exception {
        return "Member/Employee/employee_login";
    }

    // 일반 사원 로그인에서 "로그인" 클릭시
    @GetMapping(value="employee_login_action")
    public String login(@RequestParam("emp_id") String id, @RequestParam("emp_pass") String pass) throws Exception{
        return "Member/test";
    }
    
    

    
    // 일반 사원 로그인에서 "사원가입" 클릭시
    @GetMapping(value="/join")
    public String join() throws Exception {
        return "Member/Employee/join";
    }

    // "사원가입"에서 "사원가입" 클릭시.
    @PostMapping("/employee_join")
    public String employee_join(@ModelAttribute MemberDTO memberdto, Errors errors, Model model)throws Exception {
        if(errors.hasErrors()){
            model.addAttribute("memberdto",memberdto);
            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for(String key : validatorResult.keySet()){
                model.addAttribute(key,validatorResult.get(key));
            }
            return "Member/Employee/join";
        }
        memberService.join(memberdto);
        return "home";
    }

    // "관라자 로그인"에서 "Login"클릭했을때.
    // 관리자 비밀번호 확인 창
    @GetMapping(value="check_manager_pass")
    public String check_manager_pass()throws Exception {
        return "Member/Manager/manager_pass_check";
    }





}
