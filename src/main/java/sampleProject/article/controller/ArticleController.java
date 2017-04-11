package sampleProject.article.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sampleProject.article.domain.Article;
import sampleProject.article.service.ArticleService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    Logger LOG = Logger.getLogger(this.getClass());

    @Resource
    private ArticleService articleService;

    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    public ModelAndView viewArticle(ModelAndView modelAndView, @PathVariable Integer articleId) throws Exception {

        Article article = articleService.getArticle(new Article(articleId));

        if (article != null) {
            // 게시물 읽기 뷰페이지 지정
            modelAndView.addObject("article", article);
            modelAndView.setViewName("/article/articleDetail");
        } else {
            // 게시물 없음 뷰페이지 지정
            modelAndView.setViewName("/common/pageNotFound");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{articleId}", method = RequestMethod.GET)
    public ModelAndView editArticle(ModelAndView mv, @PathVariable Integer article_id, HttpSession session) throws Exception {

        /*
         * spring security / session 사용여부 확정후 구현
         * 
         */
        return mv;
    }

}