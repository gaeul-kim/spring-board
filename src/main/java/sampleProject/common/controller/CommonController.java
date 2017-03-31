package sampleProject.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
    Logger LOG = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "/common/main";
    }
}
