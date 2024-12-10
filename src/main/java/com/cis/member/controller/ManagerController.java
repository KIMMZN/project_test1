package com.cis.member.controller;

import com.cis.member.service.IF_MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagerController {

    @Autowired
    IF_MemberService memberService;

    @PostMapping(value="ajaxStr")
    public Object check_pass(@RequestBody String emp_id) throws Exception{
        String[] a = emp_id.split("=");
        String result = a[1];
        int check_return = memberService.count_id(result);
        return check_return;
    }








}
