package sampleProject.user.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    @NotNull
    @Size(min = 5, max = 15, message = "5~15자의 영문 소문자, 숫자만 가능")
    @Pattern(regexp = "/^[a-z0-9+]{5,15}$/")
    private String user_id;

    @NotNull
    // "/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{5,15}$/"
    @Size(min = 5, max = 15, message = "")
    private String user_password;

    @NotNull
    @Pattern(regexp = "/^[가-힣]{2,5}|[a-zA-Z]{4,10}$/")
    @Size(min = 2, max = 10, message = "")
    private String user_name;

    @NotNull
    @Pattern(regexp = "/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i")
    @Size(min = 3)
    private String user_email;

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
