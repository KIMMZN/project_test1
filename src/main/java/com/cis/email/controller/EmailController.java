package com.cis.email.controller;

import com.cis.Pagination;
import com.cis.email.dto.EmailDTO;
import com.cis.email.service.IF_EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    IF_EmailService emailservice;

    @GetMapping(value = "email")
    public String email(@RequestParam(defaultValue = "1") int page , Model model) throws Exception {
        int totalListCnt = emailservice.emailListCnt();
        Pagination pagination = new Pagination(totalListCnt, page);

        int startIndex = pagination.getStartIndex();
        int pageSize = pagination.getPageSize();
        pagination.setSelectPage(page);

        List<EmailDTO> email_list = emailservice.emailList(startIndex, pageSize);

        model.addAttribute("email_list", email_list);
        model.addAttribute("pagination", pagination);

        return "email/mail";
    }

    @PostMapping(value = "email_delete")
    public String emailDelete(@RequestParam("num") List<String> email_num_list) throws Exception {
        for (int i=0; i<email_num_list.size(); i++) {
            String email_num = email_num_list.get(i);
            emailservice.emailDelete(email_num);
        }
        return "redirect:email";
    }

    @GetMapping(value = "email_send")
    public String mailSend() {
        return "email/mail_send";
    }

    @PostMapping(value = "email_insert")
    public String mailInsert(@ModelAttribute EmailDTO emaildto) throws Exception {
        emailservice.emailInsert(emaildto);
        return "redirect:email";
    }

    @GetMapping(value = "email_detail")
    public String mailDetail(@RequestParam("num") String email_num, Model model) throws Exception {
        EmailDTO email_one = emailservice.emailOne(email_num);
        model.addAttribute("email_one", email_one);
        return "email/mail_detail";
    }

}
