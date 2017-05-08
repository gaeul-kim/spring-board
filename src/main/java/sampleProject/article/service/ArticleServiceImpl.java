package sampleProject.article.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import sampleProject.article.dao.ArticleDAO;
import sampleProject.article.domain.Article;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    Logger log = Logger.getLogger(this.getClass());

    @Resource
    private ArticleDAO articleDAO;

    @Override
    public Map<String, Object> getArticles(Map<String, Object> params) throws Exception {
        return articleDAO.selectArticles(params);
    }

    @Override
    public Article getArticle(Article article) throws Exception {

        articleDAO.updateHit(article);
        return articleDAO.selectArticle(article);
    }

    @Override
    public Article setArticle(Article article) throws Exception {

        // 삽입된 데이터의 article_id를 파라미터 객체에 넣어줌(sequence)
        // 작성 후 해당 글 보기
        /*
         * if (article.getArticleTag() != null) {
         * article.setArticleTitle(article.getArticleTag().concat(article.
         * getArticleTitle())); }
         */

        articleDAO.insertArticle(article);
        return getArticle(article);
    }

    @Override
    public Boolean deleteArticle(Article article) throws Exception {
        if (articleDAO.updateDeleteDate(article) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean editArticle(Article article) throws Exception {
        if (articleDAO.updateArticle(article) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean hasArticleCategory(String category) throws Exception {
        if (articleDAO.selectArticleCategory(category) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<String> getArticleTags(String category) throws Exception {
        return articleDAO.selectArticleTags(category);
    }
}
