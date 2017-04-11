package sampleProject.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sampleProject.article.dao.ArticleDAO;
import sampleProject.article.domain.Article;
import sampleProject.article.service.ArticleService;
import sampleProject.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/interceptor-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class UserTest {
    Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleDAO boardDAO;

    @Autowired
    private ArticleService boardService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void checkUserId() throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", "admin");

        Boolean availableUserId = userService.checkUserId(map);

        assertEquals(false, availableUserId);
    }

    @Ignore
    @Test
    public void insertArticle() throws Exception {
        // boardDAO.deleteAll();

        for (int i = 0; i < 15; i++) {

            Long currentTime = System.currentTimeMillis();
            Article article = new Article();
            article.setArticleTitle("제목" + currentTime);
            article.setArticleContent("가나다" + i);
            article.setArticleWriter("sangsik");
            article.setArticlePassword("1234");
            article.setArticleCategory("qna");

            boardDAO.insertArticle(article);
        }
    }

    @Test
    public void selectArticles() throws Exception {
        LOG.debug(boardDAO.selectArticles("test"));
    }

    @Test
    public void selectArticle() throws Exception {
        Article article1 = new Article();
        article1.setArticleId(15);

        Article article2 = boardService.getArticle(article1);

        assertThat(article1.getArticleId(), is(article2.getArticleId()));
    }

    @Test
    public void updateDeleteDate() throws Exception {

        Article article = new Article();
        article.setArticleId(21);
        boardService.deleteArticle(article);
    }

    @Test
    public void hasCategory() throws Exception {
        assertTrue(boardService.hasArticleCategory("qna"));
    }

    @Test
    public void hasNotCategory1() throws Exception {
        assertFalse(boardService.hasArticleCategory("dasf"));
    }
    @Test
    public void hasNotCategory2() throws Exception {
        assertFalse(boardService.hasArticleCategory(""));
    }

}
