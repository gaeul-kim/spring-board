package sampleProject.user.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import sampleProject.user.dao.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService {
    Logger log = Logger.getLogger(this.getClass());

    @Resource(name = "userDAO")
    private UserDAO userDAO;

    @Override
    public String checkUserId(HashMap<String, Object> param) throws Exception {
        if (0 < userDAO.selectUserId(param)) {
            return "fail";
        }
        return "success";
    }

}
