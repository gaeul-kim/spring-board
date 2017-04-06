package sampleProject.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sampleProject.board.domain.Article;
import sampleProject.board.service.BoardService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    Logger LOG = Logger.getLogger(this.getClass());

    @Resource
    private BoardService boardService;

    @RequestMapping(value = "/{article_id}", method = RequestMethod.GET)
    public ModelAndView viewArticle(ModelAndView mv, @PathVariable Integer article_id) throws Exception {

        Article article = boardService.getArticle(new Article(article_id));

        if (article != null) {
            // 게시물 읽기 뷰페이지 지정
            mv.addObject("article", article);
            mv.setViewName(null);
        } else {
            // 게시물 없음 뷰페이지 지정
            mv.setViewName(null);
        }
        return mv;
    }

    @RequestMapping(value = "/edit/{article_id}", method = RequestMethod.GET)
    public ModelAndView editArticle(ModelAndView mv, @PathVariable Integer article_id, HttpSession session) throws Exception {

        /*
         * spring security / session 사용여부 확정후 구현
         * 
         */
        return mv;
    }

}
