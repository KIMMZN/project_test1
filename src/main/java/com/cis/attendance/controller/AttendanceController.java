package com.cis.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AttendanceController {

    @GetMapping(value = "attendance")
    public String attendance(Model model) {
        return "attendance/attendance";
    }

    @PostMapping(value = "work_start")
    public String workStart(Model model) {
        System.out.println("work_start Controller");
        return "redirect:attendance";
    }
}
