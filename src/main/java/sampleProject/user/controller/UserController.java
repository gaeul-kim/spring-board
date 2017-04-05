package sampleProject.user.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sampleProject.user.domain.User;
import sampleProject.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    Logger LOG = Logger.getLogger(this.getClass());

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSign(@Valid User user, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            return "/user/register";
        } else {
            userService.registerUser(user);
            LOG.debug(user.getUser_idx());
        }
        return "user/success";
    }

    @RequestMapping("/checkId")
    @ResponseBody
    public HashMap<String, Object> checkId(@ModelAttribute User user) throws Exception {

        Boolean availableUserId = userService.checkUserId(user);

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        if (!availableUserId) {
            resultMap.put("result", "fail");
        } else if (availableUserId) {
            resultMap.put("result", "success");
        }
        return resultMap;
    }
}
