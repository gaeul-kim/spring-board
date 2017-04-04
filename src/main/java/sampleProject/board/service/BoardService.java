package sampleProject.board.service;

import java.util.List;

import sampleProject.board.domain.Article;

public interface BoardService {

    List<Article> articleList() throws Exception;

    Article articleDetail(Article article) throws Exception;

    Article articleWrite(Article article) throws Exception;
    
    Article articleModify(Article article) throws Exception;

    void articleDelete(Article article) throws Exception;
}
