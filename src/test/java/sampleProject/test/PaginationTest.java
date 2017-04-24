package sampleProject.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sampleProject.article.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/interceptor-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/spring-security.xml" })
public class PaginationTest {

    Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    ArticleService articleService;

    @Before
    public void setUp() throws Exception {

    }

    @Ignore
    @Test
    public void pagination() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        // params.put("currentPageNo", 0);
        params.put("articleCategory", "free");

    }

    @Test
    public void list() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("articleCategory", "free");
        // map.put("currentPageNo",1);
        Map<String, Object> returnMap = articleService.getArticles(map);

        LOG.debug(returnMap.get("result"));
        LOG.debug(returnMap.get("paginationInfo"));
    }

}
