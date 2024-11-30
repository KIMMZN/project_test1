package com.cis.email.repository;

import com.cis.email.dto.EmailDTO;
import com.cis.email.dto.EmailFileDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IF_EmailRepository {
    public void emailInsert(EmailDTO emailDTO) throws Exception;
    public List<EmailDTO> emailSelectAll(int startIndex, int pageSize) throws Exception;
    public List<EmailDTO> emailSelectCheckAll(int startIndex, int pageSize, String filter) throws Exception;
    public EmailDTO emailSelectOne(String email_num) throws Exception;
    public String emailSelectOrderOne() throws Exception;
    public int emailSelectAllCnt() throws Exception;
    public int emailSelectCheckAllCnt(String filter) throws Exception;
    public void emailUpdate(String email_num);
    public void emailDelete(String email_num) throws Exception;
    public void emailFileInsert(List<EmailFileDTO> email_files) throws Exception;
    public List<EmailFileDTO> emailNumFind(String mail_num) throws Exception;
    public List<EmailFileDTO> emailFileNameFind(List<String> file_name) throws Exception;
    public EmailFileDTO emailFileFind(String file_name) throws Exception;
}
