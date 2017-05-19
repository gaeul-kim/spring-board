package sampleProject.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sampleProject.common.dao.AbstractDAO;
import sampleProject.member.vo.Member;

@Repository("memberDAO")
public class MemberDAO extends AbstractDAO {

    public Integer selectMemberId(HashMap<String, Object> param) throws Exception {
        return (Integer) selectOne("member.selectMemberId", param);
    }

    public Integer selectMemberId(Member member) throws Exception {
        return (Integer) selectOne("member.selectMemberId", member);
    }

    public Integer insertMember(Member member) throws Exception {
        return (Integer) insert("member.insertMember", member);
    }

    public void insertAuthority(Map<String, Object> params) {
        insert("member.insertAuthority", params);
    }

}
