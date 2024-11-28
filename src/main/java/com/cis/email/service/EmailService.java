package com.cis.email.service;

import com.cis.email.dto.EmailDTO;
import com.cis.email.repository.IF_EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IF_EmailService {

    @Autowired
    IF_EmailRepository emailrepository;

    @Override
    public void emailInsert(EmailDTO emailDTO) throws Exception {
        emailrepository.emailInsert(emailDTO);
    }

    @Override
    public List<EmailDTO> emailList(int startIndex, int pageSize) throws Exception {
        List<EmailDTO> email_list = emailrepository.emailSelectAll(startIndex, pageSize);
        return email_list;
    }

    @Override
    public EmailDTO emailOne(String email_num) throws Exception {
        EmailDTO email_one = emailrepository.emailSelectOne(email_num);
        return email_one;
    }

    @Override
    public int emailListCnt() throws Exception {
        int totalListCnt = emailrepository.emailSelectAllCnt();
        return totalListCnt;
    }

    @Override
    public void emailDelete(String email_num) throws Exception {
        emailrepository.emailDelete(email_num);
    }

}
