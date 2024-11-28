package com.cis.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendanceController {

    @GetMapping(value = "attendance")
    public String attendance(Model model) {
        return "attendance/attendance";
    }

}
