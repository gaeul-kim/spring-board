package sampleProject.common.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/*
 * 인증 실패 핸들러
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    Logger LOG = Logger.getLogger(this.getClass());

    private String loginIdName; // 로그인 id값이 들어오는 input 태그 name
    private String loginPasswordName; // 로그인 password 값이 들어오는 input 태그 name
    private String loginRedirectName; // 로그인 성공시 redirect 할 URL이 지정되어 있는
                                      // input태그name
    private String exceptionMessageName; // 예외 메시지를 request의 Attribute에 저장할 때
                                         // 사용될 key 값
    private String defaultFailureUrl; // 화면에 보여줄 URL(로그인 화면)

    public CustomAuthenticationFailureHandler() {
        this.loginIdName = "memberId";
        this.loginPasswordName = "memberPassword";
        this.loginRedirectName = "loginRedirect";
        this.exceptionMessageName = "securityExceptionMessage";
        this.defaultFailureUrl = "/member/login";
    }

    public String getLoginIdName() {
        return loginIdName;
    }

    public void setLoginIdName(String loginIdName) {
        this.loginIdName = loginIdName;
    }

    public String getLoginPasswordName() {
        return loginPasswordName;
    }

    public void setLoginPasswordName(String loginPasswordName) {
        this.loginPasswordName = loginPasswordName;
    }

    public String getLoginRedirectName() {
        return loginRedirectName;
    }

    public void setLoginRedirectName(String loginRedirectName) {
        this.loginRedirectName = loginRedirectName;
    }

    public String getExceptionMessageName() {
        return exceptionMessageName;
    }

    public void setExceptionMessageName(String exceptionMessageName) {
        this.exceptionMessageName = exceptionMessageName;
    }

    public String getDefaultFailureUrl() {
        return defaultFailureUrl;
    }

    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException)
            throws IOException, ServletException {
        /*
         * Request 객체의 Attribute에 사용자가 실패시 입력했던 로그인 ID와 비밀번호를 저장해두어 로그인 페이지에서 이를
         * 접근하도록 한다
         */
        String loginId = request.getParameter(loginIdName);
//        String loginPassword = request.getParameter(loginPasswordName);
        String loginRedirect = request.getParameter(loginRedirectName);
        
        request.setAttribute("loginId", loginId);
        request.setAttribute("loginRedirect", loginRedirect);
        

        /*
         * Request 객체의 Attribute에 예외 메세지 저장
         */
        request.setAttribute(exceptionMessageName, authenticationException.getMessage());
        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
    }
}
