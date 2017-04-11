package sampleProject.article.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sampleProject.article.domain.Article;
import sampleProject.article.service.ArticleService;

@Controller
@RequestMapping(value = "/articles")
public class ArticlesController {
    Logger LOG = Logger.getLogger(this.getClass());

    @Resource
    private ArticleService articleService;

    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public String articleRoot() throws Exception {
        return "/common/main";

    }

    @RequestMapping(value = "/{articleCategory}", method = RequestMethod.GET)
    public String articleList(Model model, @PathVariable String articleCategory) throws Exception {

        // 요청한 게시판이 존재하는지 확인 후 목록 검색
        if (articleService.hasArticleCategory(articleCategory)) {
            List<Article> articles = articleService.getArticles(articleCategory);
            model.addAttribute("articles", articles);
            model.addAttribute("articleCategory", articleCategory);
            return "article/articleList";
        } else {
            return "/common/main";
        }
    }

    @RequestMapping(value = "/{articleCategory}/write", method = RequestMethod.GET)
    public String articleWrite(Model model, @PathVariable String articleCategory) throws Exception {

        // 요청한 게시판이 존재하는지 확인 후 글쓰기 폼을 설정
        if (articleService.hasArticleCategory(articleCategory)) {
            model.addAttribute("articleCategory", articleCategory);
            model.addAttribute("articleCategories", articleService.getArticleCategories(articleCategory));
            return "article/articleWrite";
        }
        return "common/pageNotFound";

    }
}
