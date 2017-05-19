package sampleProject.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sampleProject.comment.service.CommentService;
import sampleProject.comment.vo.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/interceptor-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/spring-security.xml" })
public class CommentTest {

    Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    private CommentService commentService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        Comment comment = new Comment();
        comment.setArticleId(1096);
        comment.setCommentWriter("sangsik");
        comment.setCommentContent("댓글테스트");
        //comment.setCommentParentsId(29);
        assertTrue(commentService.setComment(comment));
    }

    @Ignore
    @Test
    public void select() throws Exception {
        Integer articleId = 1093;

        List<Comment> replies = commentService.getComments(articleId);
        for (Comment r : replies) {
            LOG.debug("[Id : " + r.getCommentId() + "]" + "[Writer : " + r.getCommentWriter() + "]" + "[Content : " + r.getCommentContent() + "]"
                    + "[InsertDate : " + r.getCommentInsertDate() + "]" + "[ParentsId : " + r.getCommentParentsId() + "]" + "[ArticleId : "
                    + r.getArticleId() + "]");
        }
    }

}
