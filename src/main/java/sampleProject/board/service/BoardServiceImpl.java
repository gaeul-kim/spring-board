package sampleProject.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import sampleProject.board.dao.BoardDAO;
import sampleProject.board.domain.Article;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    Logger log = Logger.getLogger(this.getClass());

    @Resource
    private BoardDAO boardDAO;

    @Override
    public List<Article> articleList() throws Exception {
        return boardDAO.selectArticles();
    }

    @Override
    public Article articleDetail(Article article) throws Exception {
        boardDAO.updateHit(article);
        return boardDAO.selectArticle(article);
    }

    @Override
    public Article articleWrite(Article article) throws Exception {

        // 삽입된 데이터의 article_id를 파라미터 객체에 넣어줌(sequence)
        // 작성 후 해당 글 보기
        boardDAO.insertArticle(article);
        return boardDAO.selectArticle(article);
    }

    @Override
    public void articleDelete(Article article) throws Exception {
        boardDAO.updateDeleteDate(article);
    }

    @Override
    public Article articleModify(Article article) throws Exception {
        boardDAO.updateArticle(article);
        return boardDAO.selectArticle(article);
    }

}
