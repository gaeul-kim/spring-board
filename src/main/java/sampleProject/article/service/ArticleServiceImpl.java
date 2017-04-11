package sampleProject.article.service;

import java.util.List;

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
    public List<Article> getArticles(String category) throws Exception {
        return articleDAO.selectArticles(category);
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
        articleDAO.insertArticle(article);
        return articleDAO.selectArticle(article);
    }

    @Override
    public void deleteArticle(Article article) throws Exception {
        articleDAO.updateDeleteDate(article);
    }

    @Override
    public Article editArticle(Article article) throws Exception {
        articleDAO.updateArticle(article);
        return articleDAO.selectArticle(article);
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
    public List<String> getArticleCategories(String category) throws Exception {
        return articleDAO.selectArticleCategories(category);
    }

}
