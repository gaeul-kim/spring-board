package sampleProject.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import sampleProject.test.domain.TestUser;

@Controller
public class TestController {
    Logger LOG = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("user", new TestUser());

        return "/user/test";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView testSubmit(@ModelAttribute @Valid TestUser user, BindingResult bindingResult, SessionStatus status)
            throws ServletException, IOException {

        ModelAndView mv = new ModelAndView();
        if (bindingResult.hasErrors()) {
            
            List<ObjectError> list = bindingResult.getAllErrors();
            for (ObjectError e : list) {
                LOG.error(e);
            }
            mv.setView(new RedirectView("/"));
            return mv;
        }
        mv.setViewName("/user/register");
        return mv;
    }

}
