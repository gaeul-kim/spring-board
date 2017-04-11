package sampleProject.member.service;

import java.util.HashMap;

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

}
