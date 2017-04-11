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

    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public String boardRoot() throws Exception {
        return "/common/main";

    }

    @RequestMapping(value = "/{boardCategory}", method = RequestMethod.GET)
    public String articleList(Model model, @PathVariable String boardCategory) throws Exception {

        // 요청한 게시판이 존재하는지 확인 후 목록 검색
        if (boardService.hasBoardCategory(boardCategory)) {
            List<Article> articles = boardService.getArticles(boardCategory);
            model.addAttribute("articles", articles);
            model.addAttribute("boardCategory", boardCategory);
            return "board/articleList";
        } else {
            return "/common/main";
        }
    }

    @RequestMapping(value = "/{boardCategory}/write", method = RequestMethod.GET)
    public String articleWrite(Model model, @PathVariable String boardCategory) throws Exception {

        // 요청한 게시판이 존재하는지 확인 후 글쓰기 폼을 설정
        if (boardService.hasBoardCategory(boardCategory)) {
            model.addAttribute("boardCategory", boardCategory);
            model.addAttribute("articleCategories", boardService.getArticleCategories(boardCategory));
        }
        return "board/articleWrite";
    }
}
