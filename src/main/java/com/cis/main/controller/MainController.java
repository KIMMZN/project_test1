package com.cis.main.controller;

import com.cis.Pagination;
import com.cis.attendance.dto.AttendanceDTO;
import com.cis.attendance.service.IF_AttendanceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private IF_AttendanceService attendanceService;

    // 게시판, 근태관리, 개인업무 목록 조회, 직원 메인화면 페이지 이동
    @GetMapping(value = "emp_main")
    public String empMain(Model model,
                          HttpSession httpSession) throws Exception {
        Object login_emp = httpSession.getAttribute("employee_id");
        if (login_emp == null) return "total_login";

        // 메인화면 목록 리스트 출력하기
        // 자유게시판

        // 공지사항

        // 근태관리
        Pagination pagination = new Pagination(6, 3, 1);
        pagination.setStartIndex(0);
        pagination.setPageSize(3);

        List<AttendanceDTO> attendance_list = attendanceService.attendanceList(login_emp, pagination);

        model.addAttribute("attendance_list", attendance_list);
        // 개인업무


        return "main/emp_main";
    }

    // 관리자 메인화면 페이지 이동
    @GetMapping(value = "manager_main")
    public String managerMain() {
        return "main/manager_main";
    }

}
