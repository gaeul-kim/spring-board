package sampleProject.user.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    Logger LOG = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSign(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // List<ObjectError> list = bindingResult.getAllErrors();
            // for (ObjectError e : list) {
            // LOG.debug(e);
            // }
            return "/user/register";
        }
        return "user/success";
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
