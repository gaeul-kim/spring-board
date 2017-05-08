package sampleProject.article.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import sampleProject.article.domain.Article;
import sampleProject.common.dao.AbstractDAO;

@Repository("articleDAO")
public class ArticleDAO extends AbstractDAO {

    @SuppressWarnings("unchecked")
    public Map<String, Object> selectArticles(Map<String, Object> params) throws Exception {
        return selectPagingList("article.selectArticles", params);
    }

    public Article selectArticle(Article article) throws Exception {
        return (Article) selectOne("article.selectArticle", article);
    }

    public void insertArticle(Article article) throws Exception {
        insert("article.insertArticle", article);
    }

    public Integer updateHit(Article article) throws Exception {
       return (Integer) update("article.updateHit", article);
    }

    public Integer updateDeleteDate(Article article) throws Exception {
        return (Integer) update("article.updateDeleteDate", article);
    }

    public Integer updateArticle(Article article) throws Exception {
        return (Integer) update("article.updateArticle", article);
    }

    public Integer selectArticleCategory(String articleCategory) throws Exception {
        return (Integer) selectOne("article.selectArticleCategory", articleCategory);
    }

    @SuppressWarnings("unchecked")
    public List<String> selectArticleTags(String articleCategory) throws Exception {
        return selectList("article.selectArticleTags", articleCategory);
    }
}
