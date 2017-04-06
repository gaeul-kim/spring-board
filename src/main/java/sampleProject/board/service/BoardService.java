package sampleProject.board.service;

import java.util.List;

import sampleProject.board.domain.Article;

public interface BoardService {

    List<Article> getArticles(String category) throws Exception;

    Article getArticle(Article article) throws Exception;

    Article writeArticle(Article article) throws Exception;
    
    Article editArticle(Article article) throws Exception;

    void deleteArticle(Article article) throws Exception;
}
