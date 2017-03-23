package sampleProject.user.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
    @NotEmpty(message = "필수 입력")
    @Size(min = 5, max = 15, message = "5~15자의 영문 소문자/숫자")
    private String user_id;

    @NotEmpty(message = "필수 입력")
    @Size(min = 5, max = 15, message = "5~15자의 영문 대소문자와 숫자/특수문자를 포함")
    private String user_password;

    @NotEmpty(message = "필수 입력")
    @Size(min = 2, max = 10, message = "2~10자의 한글, 4~10자의 영문자")
    private String user_name;

    @NotEmpty(message = "필수 입력")
    @Email(message = "이메일 주소가 유효하지 않습니다")
    private String user_email;

    @NotEmpty(message = "필수 입력")
    @Size(min = 5, max = 15, message = "5~15자의 영문 대소문자와 숫자/특수문자를 포함")
    private String confirm_password;

    public String getconfirm_password() {
        return confirm_password;
    }

    public void setconfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

}
