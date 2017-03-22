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

import sampleProject.test.domain.Member;

@Controller
public class TestController {
    Logger LOG = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("member", new Member());

        return "/user/test";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String testSubmit(@ModelAttribute @Valid Member member, BindingResult bindingResult)
            throws ServletException, IOException {

        if (bindingResult.hasErrors()) {

            List<ObjectError> list = bindingResult.getAllErrors();
            for (ObjectError e : list) {
                LOG.error(e.getDefaultMessage());
            }
            return "/user/test";
        }
        return "/user/register";
    }

}
