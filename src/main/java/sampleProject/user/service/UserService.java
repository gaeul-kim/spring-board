package sampleProject.user.service;

import java.util.HashMap;

import sampleProject.user.domain.User;

public interface UserService {

    Boolean checkUserId(HashMap<String, Object> param) throws Exception;

    Boolean checkUserId(User user) throws Exception;

    void registerUser(User user) throws Exception;

}
