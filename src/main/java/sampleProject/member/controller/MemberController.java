package sampleProject.member.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sampleProject.member.domain.Member;
import sampleProject.member.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
    Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Resource(name = "memberService")
    private MemberService memberService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("member", new Member());
        return "/member/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSubmit(@Valid Member member, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            return "/member/register";
        } else {
            member.setMemberPassword(passwordEncoder.encode(member.getPassword()));
            memberService.registerMember(member);
            memberService.grantBasicAuthority(member);
            LOG.debug(member.getMemberIdx());
        }
        return "member/success";
    }

    @RequestMapping("/checkId")
    @ResponseBody
    public HashMap<String, Object> checkId(@ModelAttribute Member member) throws Exception {

        Boolean availableMemberId = memberService.checkMemberId(member);

        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        if (!availableMemberId) {
            resultMap.put("result", "fail");
        } else if (availableMemberId) {
            resultMap.put("result", "success");
        }
        return resultMap;
    }

    @RequestMapping("/login")
    public String loginForm() throws Exception {
        return "member/login";
    }

}
