package sampleProject.user.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import sampleProject.common.dao.AbstractDAO;

@Repository("userDAO")
public class UserDAO extends AbstractDAO {

    public Integer selectUserId(HashMap<String, Object> param) throws Exception {
        return (Integer) selectOne("user.selectUserId", param);
    }

}
