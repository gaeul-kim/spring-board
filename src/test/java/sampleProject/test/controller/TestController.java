package sampleProject.test.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    Logger LOG = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(Model model) {
        return "/user/test";
    }
}
