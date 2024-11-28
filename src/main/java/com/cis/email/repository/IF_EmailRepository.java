package com.cis.email.repository;

import com.cis.email.dto.EmailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IF_EmailRepository {
    public void emailInsert(EmailDTO emailDTO) throws Exception;
    public List<EmailDTO> emailSelectAll(int startIndex, int pageSize) throws Exception;
    public EmailDTO emailSelectOne(String email_num) throws Exception;
    public int emailSelectAllCnt() throws Exception;
    public void emailDelete(String email_num) throws Exception;
}
