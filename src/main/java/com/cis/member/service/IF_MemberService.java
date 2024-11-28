package com.cis.member.service;

import com.cis.member.dto.MemberDTO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface IF_MemberService {
    public void join(MemberDTO memberDTO) throws Exception;
    public Map<String, String> validateHandling(Errors errors);
    public MemberDTO login(String id, String pass) throws Exception;
    public int check_duplicate_id(String id) throws Exception;
    public MemberDTO selectCheckMember(String id) throws Exception;
    public Object overlay(String id)throws Exception ;
}