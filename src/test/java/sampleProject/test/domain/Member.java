package sampleProject.test.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Member {
    @NotEmpty(message = "아이디를 입력하세요!")
    private String id;

    @NotEmpty(message = "비밀번호를 입력하세요!")
    private String password;

    @NotEmpty(message = "이메일을 입력하세요!")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
