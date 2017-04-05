package sampleProject.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sampleProject.board.dao.BoardDAO;
import sampleProject.board.domain.Article;
import sampleProject.board.service.BoardService;
import sampleProject.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/interceptor-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class UserTest {
    Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private BoardDAO boardDAO;

    @Autowired
    private BoardService boardService;

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

    @Test
    public void insertArticle() throws Exception {
        // boardDAO.deleteAll();

        Long currentTime = System.currentTimeMillis();
        Article article = new Article();
        article.setArticle_title("제목" + currentTime);
        article.setArticle_content("가나다");
        article.setArticle_writer("sangsik");
        article.setArticle_password("1234");
        article.setArticle_category("test");

        boardDAO.insertArticle(article);
    }

    @Test
    public void selectArticles() throws Exception {
        LOG.debug(boardDAO.selectArticles("test"));
    }

    @Test
    public void selectArticle() throws Exception {
        Article article1 = new Article();
        article1.setArticle_id(15);

        Article article2 = boardService.getArticle(article1);

        assertThat(article1.getArticle_id(), is(article2.getArticle_id()));
    }

    @Test
    public void updateDeleteDate() throws Exception {

        Article article = new Article();
        article.setArticle_id(21);
        boardService.deleteArticle(article);
    }

}
