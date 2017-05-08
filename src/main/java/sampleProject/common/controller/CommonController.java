package sampleProject.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
    Logger LOG = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "/common/main";
    }

    @RequestMapping(value = "/common/pageNotFound")
    public String pageNotFound() {
        return "common/pageNotFound";
    }

    @RequestMapping(value = "/common/notYetFinished")
    public String notYetFinished() {
        return "common/notYetFinished";
    }

    @RequestMapping(value = "/common/serverError")
    public String serverError() {
        return "common/serverError";
    }
    @RequestMapping(value = "/common/accessDenied")
    public String accessDenied() {
        return "common/accessDenied";
    }

}
