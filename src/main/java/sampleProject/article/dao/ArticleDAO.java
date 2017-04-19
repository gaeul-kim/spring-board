package sampleProject.article.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import sampleProject.article.domain.Article;
import sampleProject.common.dao.AbstractDAO;

@Repository("articleDAO")
public class ArticleDAO extends AbstractDAO {

    @SuppressWarnings("unchecked")
    public List<Article> selectArticles(String articleCategory) throws Exception {
        return selectList("article.selectArticles", articleCategory);
    }

    public Article selectArticle(Article article) throws Exception {
        return (Article) selectOne("article.selectArticle", article);
    }

    public void insertArticle(Article article) throws Exception {
        insert("article.insertArticle", article);
    }

    public void updateHit(Article article) throws Exception {
        update("article.updateHit", article);
    }

    public void updateDeleteDate(Article article) throws Exception {
        update("article.updateDeleteDate", article);
    }

    public void updateArticle(Article article) throws Exception {
        update("article.updateArticle", article);
    }

    public Integer selectArticleCategory(String articleCategory) throws Exception {
        return (Integer) selectOne("article.selectArticleCategory", articleCategory);
    }

    @SuppressWarnings("unchecked")
    public List<String> selectArticleTags(String articleCategory) throws Exception {
        return selectList("article.selectArticleTags", articleCategory);
    }

}
