package sampleProject.article.service;

import java.util.List;
import java.util.Map;

import sampleProject.article.domain.Article;

public interface ArticleService {

    Map<String, Object> getArticles(Map<String, Object> params) throws Exception;

    Article getArticle(Article article) throws Exception;

    Article setArticle(Article article) throws Exception;

    Boolean editArticle(Article article) throws Exception;

    Boolean deleteArticle(Article article) throws Exception;

    Boolean hasArticleCategory(String articleCategory) throws Exception;

    List<String> getArticleTags(String articleCategory) throws Exception;

}
