package sampleProject.member.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import sampleProject.member.dao.MemberDAO;
import sampleProject.member.domain.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    Logger log = Logger.getLogger(this.getClass());

    @Resource(name = "memberDAO")
    private MemberDAO memberDAO;

    @Override
    public Boolean checkMemberId(HashMap<String, Object> param) throws Exception {
        if (memberDAO.selectMemberId(param) > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean checkMemberId(Member member) throws Exception {
        if (memberDAO.selectMemberId(member) > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void registerMember(Member member) throws Exception {
        if (checkMemberId(member)) {
            memberDAO.insertMember(member);
        }
    }

    @Override
    public void grantBasicAuthority(Member member) throws Exception {
        // 기본 권한(USER)부여. 권한부여 기능을 관리하는 부분을 분리해야함
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("memberId", member.getMemberId());
        map.put("authorityCode", "USER");

        memberDAO.insertAuthority(map);
    }

}
