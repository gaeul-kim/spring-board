package sampleProject.member.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Member {
    @NotEmpty(message = "필수 입력")
    @Size(min = 5, max = 15, message = "5~15자의 영문 소문자/숫자")
    private String memberId;

    @NotEmpty(message = "필수 입력")
    @Size(min = 5, max = 15, message = "5~15자의 영문 대소문자와 숫자/특수문자를 포함")
    private String memberPassword;

    @NotEmpty(message = "필수 입력")
    @Size(min = 2, max = 10, message = "2~10자의 한글, 4~10자의 영문자")
    private String memberName;

    @NotEmpty(message = "필수 입력")
    @Email(message = "이메일 주소가 유효하지 않습니다")
    private String memberEmail;

    @NotEmpty(message = "필수 입력")
    @Size(min = 5, max = 15, message = "5~15자의 영문 대소문자와 숫자/특수문자를 포함")
    private String confirmPassword;

    private Integer memberIdx;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Integer getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(Integer memberIdx) {
        this.memberIdx = memberIdx;
    }

}
