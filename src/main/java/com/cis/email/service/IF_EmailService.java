package com.cis.email.service;

import com.cis.email.dto.EmailDTO;
import com.cis.email.dto.EmailFileDTO;

import java.util.List;

public interface IF_EmailService {
    public void emailInsert(EmailDTO emailDTO) throws Exception;
    public List<EmailDTO> emailList(int startIndex, int pageSize, String filter) throws Exception;
    public EmailDTO emailOne(String email_num) throws Exception;
    public String emailOrderOne() throws Exception;
    public int emailListCnt(String filter) throws Exception;
    public void emailCheckUpdate(String email_num) throws Exception;
    public void emailDelete(String email_num) throws Exception;
    public void emailFileUpload(final String mail_num, final List<EmailFileDTO> files) throws Exception;
    public List<EmailFileDTO> emailNumFind(String mail_num) throws Exception;
    public List<EmailFileDTO> emailFileNameFind(List<String> file_name) throws Exception;
    public EmailFileDTO emailFileFind(String file_name) throws Exception;
    public String recipientIdCheck(String recipient_id) throws Exception;
}
