package sampleProject.member.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sampleProject.member.dao.MemberDAO;
import sampleProject.member.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

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
            // 암호화
            member.setMemberPassword(passwordEncoder.encode(member.getMemberPassword()));
            // DB 삽입
            memberDAO.insertMember(member);
            // 권한부여 (Service 분리필요)
            grantAuthority(member);
        }
    }

    @Override
    public void grantAuthority(Member member) throws Exception {
        // 기본 권한(USER)부여(임시)
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("memberId", member.getMemberId());
        map.put("authorityCode", "USER");

        memberDAO.insertAuthority(map);
    }

}
