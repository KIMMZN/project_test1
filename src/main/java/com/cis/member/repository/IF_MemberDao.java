package com.cis.member.repository;

import com.cis.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface IF_MemberDao {
    public void insertMember(MemberDTO memberDTO) throws Exception;
    public MemberDTO selectOne(String id, String pass) throws Exception;
    public int selectCount(String id) throws Exception;
    public Object overlay(String id) throws Exception;
}
