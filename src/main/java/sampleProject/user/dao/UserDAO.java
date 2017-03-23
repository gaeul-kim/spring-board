package sampleProject.user.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import sampleProject.common.dao.AbstractDAO;
import sampleProject.user.domain.User;

@Repository("userDAO")
public class UserDAO extends AbstractDAO {

    public Integer selectUserId(HashMap<String, Object> param) throws Exception {
        return (Integer) selectOne("user.selectUserId", param);
    }

    public Integer selectUserId(User user) throws Exception {
        return (Integer) selectOne("user.selectUserId", user);
    }

    public Integer insertUser(User user) throws Exception {
        return (Integer) insert("user.insertUser", user);
    }

}
