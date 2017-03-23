package sampleProject.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sampleProject.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/interceptor-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class UserTest {
    Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

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

}
