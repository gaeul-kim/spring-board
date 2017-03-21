package sampleProject.test;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    Logger log = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/")
    public ModelAndView openSampleList() throws Exception {
        return null;
    }

}
