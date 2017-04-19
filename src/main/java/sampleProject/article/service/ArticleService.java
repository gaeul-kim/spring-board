package sampleProject.article.service;

import java.util.List;

import sampleProject.article.domain.Article;

public interface ArticleService {

    List<Article> getArticles(String articleCategory) throws Exception;

    Article getArticle(Article article) throws Exception;

    Article setArticle(Article article) throws Exception;

    Article editArticle(Article article) throws Exception;

    void deleteArticle(Article article) throws Exception;

    Boolean hasArticleCategory(String articleCategory) throws Exception;

    List<String> getArticleTags(String articleCategory) throws Exception;

}
