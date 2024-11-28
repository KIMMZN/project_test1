package com.cis.email.service;

import com.cis.email.dto.EmailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IF_EmailService {
    public void emailInsert(EmailDTO emailDTO) throws Exception;
    public List<EmailDTO> emailList(int startIndex, int pageSize) throws Exception;
    public EmailDTO emailOne(String email_num) throws Exception;
    public int emailListCnt() throws Exception;
    public void emailDelete(String email_num) throws Exception;
}
