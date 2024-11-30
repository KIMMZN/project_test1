package com.cis.email.service;

import com.cis.email.dto.EmailDTO;
import com.cis.email.dto.EmailFileDTO;
import com.cis.email.repository.IF_EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
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
    public List<EmailDTO> emailList(int startIndex, int pageSize, String filter) throws Exception {
        return switch (filter) {
            case "unread" -> emailrepository.emailSelectCheckAll(startIndex, pageSize, "N");
            case "read" -> emailrepository.emailSelectCheckAll(startIndex, pageSize, "Y");
            default -> emailrepository.emailSelectAll(startIndex, pageSize);
        };
    }

    @Override
    public EmailDTO emailOne(String email_num) throws Exception {
        return emailrepository.emailSelectOne(email_num);
    }

    @Override
    public String emailOrderOne() throws Exception {
        return emailrepository.emailSelectOrderOne();
    }

    @Override
    public int emailListCnt(String filter) throws Exception {
        return switch (filter) {
            case "unread" -> emailrepository.emailSelectCheckAllCnt("N");
            case "read" -> emailrepository.emailSelectCheckAllCnt("Y");
            default -> emailrepository.emailSelectAllCnt();
        };
    }

    @Override
    public void emailCheckUpdate(String email_num) throws Exception {
        emailrepository.emailUpdate(email_num);
    }

    @Override
    public void emailDelete(String email_num) throws Exception {
        emailrepository.emailDelete(email_num);
    }

    @Override
    public void emailFileUpload(final String mail_num, final List<EmailFileDTO> email_files) throws Exception {
        if (CollectionUtils.isEmpty(email_files)) return;
        for (EmailFileDTO email_file : email_files) {
            email_file.setMail_num(mail_num);
        }
        emailrepository.emailFileInsert(email_files);
    }

    @Override
    public List<EmailFileDTO> emailNumFind(String mail_num) throws Exception {
        return emailrepository.emailNumFind(mail_num);
    }

    @Override
    public List<EmailFileDTO> emailFileNameFind(List<String> file_name) throws Exception {
        if (CollectionUtils.isEmpty(file_name)) return Collections.emptyList();
        return emailrepository.emailFileNameFind(file_name);
    }

    @Override
    public EmailFileDTO emailFileFind(String file_name) throws Exception {
        return emailrepository.emailFileFind(file_name);
    }

}
