package sampleProject.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sampleProject.board.domain.Article;
import sampleProject.board.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
    Logger LOG = Logger.getLogger(this.getClass());

    @Resource
    private BoardService boardService;

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String articleList(Model model, @PathVariable String category) throws Exception {

        
        List<Article> articles = boardService.getArticles(category);
        model.addAttribute("articles", articles);
        return null;
    }

}
