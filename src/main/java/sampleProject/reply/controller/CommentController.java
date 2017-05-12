package sampleProject.reply.controller;

import java.security.Principal;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sampleProject.comment.domain.Comment;
import sampleProject.comment.service.CommentService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    Logger LOG = Logger.getLogger(this.getClass());

    @Resource(name = "commentService")
    private CommentService commentService;

    @RequestMapping("/write")
    @ResponseBody
    public HashMap<String, Object> commentWrite(@ModelAttribute Comment comment, Principal principal) throws Exception {

        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        comment.setCommentWriter(principal.getName());
        commentService.setComment(comment);

        resultMap.put("comments", commentService.getComments(comment.getArticleId()));

        return resultMap;
    }

    /*
     * HashMap<String, Object> resultMap = new HashMap<String, Object>(); if
     * (!availableMemberId) { resultMap.put("result", "fail"); } else if
     * (availableMemberId) { resultMap.put("result", "success"); } return
     * resultMap; }
     */
}
