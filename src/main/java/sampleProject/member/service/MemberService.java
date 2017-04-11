package sampleProject.member.service;

import java.util.HashMap;

import sampleProject.member.domain.Member;

public interface MemberService {

    Boolean checkMemberId(HashMap<String, Object> param) throws Exception;

    Boolean checkMemberId(Member member) throws Exception;

    void registerMember(Member member) throws Exception;

}
