package sampleProject.article.controller;

import java.security.Principal;

import javax.annotation.Resource;

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
    public ModelAndView editArticleForm(ModelAndView modelAndView, Principal principal, @PathVariable Integer articleId) throws Exception {
        Article article = articleService.getArticle(new Article(articleId, principal.getName()));
        if (article != null) {
            modelAndView.addObject("article", article);
            modelAndView.addObject("articleTags", articleService.getArticleTags(article.getArticleCategory()));
            modelAndView.setViewName("/article/articleEdit");
        } else {
            modelAndView.setViewName("/common/main");

        }
        return modelAndView;
    }
    
    @RequestMapping(value = "/edit/{articleId}", method = RequestMethod.POST)
    public ModelAndView editArticle(Article article) throws Exception {
          LOG.debug("RequestMethod.PUT");
        return null;
    }
    
}
