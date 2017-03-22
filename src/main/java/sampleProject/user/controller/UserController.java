package sampleProject.user.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sampleProject.user.domain.User;
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
    public String registerSign(@RequestParam HashMap<String, Object> param, @Valid User user, BindingResult bindingResult) {
        log.debug(param);

        if (bindingResult.hasErrors()) {
            log.debug(bindingResult.getAllErrors());
        }
        log.debug(user.getUser_id());
        log.debug(user.getUser_password());
        log.debug(user.getUser_name());
        log.debug(user.getUser_email());
        // 유효성 체크
        // 회원가입 로직

        return "null";
    }

    @RequestMapping("/checkId")
    @ResponseBody
    public HashMap<String, Object> checkId(@RequestParam HashMap<String, Object> param) throws Exception {

        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        Boolean availableUserId = userService.checkUserId(param);

        if (!availableUserId) {
            resultMap.put("result", "fail");
        } else if (availableUserId) {
            resultMap.put("result", "success");
        }
        return resultMap;
    }
}
