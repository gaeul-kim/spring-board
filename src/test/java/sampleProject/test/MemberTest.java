package sampleProject.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sampleProject.member.domain.Member;
import sampleProject.member.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/interceptor-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/spring-security.xml" })

public class MemberTest {
    Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MemberService memberService;

    @Before
    public void setUp() throws Exception {

    }

    @Ignore
    @Test
    public void checkMemberId() throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("memberId", "admin");

        Boolean availableUserId = memberService.checkMemberId(map);

        assertEquals(false, availableUserId);
    }

    @Ignore
    @Test
    public void wrongMemberId() throws Exception {
        Member member = new Member();
        member.setMemberId("admin");

        Boolean availableUserId = memberService.checkMemberId(member);
        assertEquals(false, availableUserId);
    }

    @Ignore
    @Test
    public void registerMember() throws Exception {
        Long currentTime = System.currentTimeMillis();

        Member member = new Member();

        LOG.debug(currentTime.toString());
        member.setMemberId(currentTime.toString());
        member.setMemberName("테스트");
        member.setMemberPassword("1234");
        member.setMemberEmail("dummy@cherry.co.kr");

        memberService.registerMember(member);
    }

    @Test
    public void passwordEncoder() throws Exception {
        String str1 = new String("hello world");

        String bCryptString1 = passwordEncoder.encode(str1);
        String bCryptString2 = passwordEncoder.encode(str1);

        LOG.debug(bCryptString1);
        LOG.debug(bCryptString2);

        assertThat(bCryptString1, not(bCryptString2));

    }
}
