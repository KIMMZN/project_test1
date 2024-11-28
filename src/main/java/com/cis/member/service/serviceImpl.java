package com.cis.member.service;

import com.cis.member.dto.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.Map;

@Service
public class serviceImpl implements IF_MemberService {
    @Override
    public void join(MemberDTO memberDTO) throws Exception {

    }

    @Override
    public Map<String, String> validateHandling(Errors errors) {
        return Map.of();
    }

    @Override
    public MemberDTO login(String id, String pass) throws Exception {
        return null;
    }

    @Override
    public int check_duplicate_id(String id) throws Exception {
        return 0;
    }

    @Override
    public MemberDTO selectCheckMember(String id) throws Exception {
        return null;
    }

    @Override
    public Object overlay(String id) throws Exception {
        return null;
    }
}
