package sampleProject.comment.controller;

import java.security.Principal;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sampleProject.comment.domain.Comment;
import sampleProject.comment.service.CommentService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    Logger LOG = Logger.getLogger(this.getClass());

    @Resource(name = "commentService")
    private CommentService commentService;

    /*
     * @RequestMapping("/write")
     * 
     * @ResponseBody public HashMap<String, Object> commentWrite(@ModelAttribute
     * Comment comment, Principal principal) throws Exception {
     * 
     * HashMap<String, Object> resultMap = new HashMap<String, Object>();
     * 
     * comment.setCommentWriter(principal.getName());
     * commentService.setComment(comment);
     * 
     * resultMap.put("comments",
     * commentService.getComments(comment.getArticleId()));
     * 
     * return resultMap; }
     */

    @RequestMapping("/write")
    public String commentWrite(@ModelAttribute Comment comment, Principal principal, Model model) throws Exception {

        comment.setCommentWriter(principal.getName());
        commentService.setComment(comment);

        model.addAttribute("comments", commentService.getComments(comment.getArticleId()));

        return "article/articleComment";
    }

    @RequestMapping("/list")
    public String commentList(Integer articleId, Model model) throws Exception {

        model.addAttribute("comments", commentService.getComments(articleId));
        return "article/articleComment";
    }
}
