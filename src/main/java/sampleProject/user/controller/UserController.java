package sampleProject.user.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm() {
        return "/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSign(@RequestParam HashMap<String, Object> param) {
        System.out.println(param);

        return "null";
    }

    @RequestMapping("/checkId")
    @ResponseBody
    public HashMap<String, Object> checkId(@RequestParam HashMap<String, Object> param) {

        System.out.println(param);

        // id 중복확인 로직
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("result", "success");

        return resultMap;
    }
}
