package sampleProject.user.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sampleProject.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    Logger log = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm() {
        return "/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSign(@RequestParam HashMap<String, Object> param) {
        log.debug(param);

        // 유효성 체크
        // 회원가입 로직

        return "null";
    }

    @RequestMapping("/checkId")
    @ResponseBody
    public HashMap<String, Object> checkId(@RequestParam HashMap<String, Object> param) throws Exception {
        log.debug(param);

        // id 중복확인 로직
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        String checkResult = userService.checkUserId(param);
        resultMap.put("result", checkResult);

        return resultMap;
    }
}
