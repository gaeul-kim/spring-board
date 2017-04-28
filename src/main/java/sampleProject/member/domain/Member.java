package sampleProject.member.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

public class Member implements UserDetails {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Pattern(regexp = "[a-z0-9+]{5,15}", message = "5~15자의 영문 소문자와 숫자만 가능")
    private String memberId;

    @Pattern(regexp = "(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{5,15}", message = "숫자나 특수문자를 포함한 5~15자의 영문 대소문자")
    private String memberPassword;

    @Pattern(regexp = "[가-힣a-zA-Z]{2,10}", message = "2~10자의 한글이나 영문만 가능")
    private String memberName;

    //@Pattern(regexp = "[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}", message = "유효하지 않은 이메일 형식")
    @Email(message="유효하지 않은 이메일 형식")
    private String memberEmail;

    @Pattern(regexp = "(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{5,15}", message = "숫자나 특수문자를 포함한 5~15자의 영문 대소문자")
    private String confirmPassword;

    private Integer memberIdx;

    private Set<GrantedAuthority> authorities;

    public Member(String memberId, String memberPassword, String memberName, Collection<? extends GrantedAuthority> authorities) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }

    public Member() {

    }

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return getMemberPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return getMemberId();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");

        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(new AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list connot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }
        return sortedAuthorities;
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            if (g2.getAuthority() == null) {
                return -1;
            }
            if (g1.getAuthority() == null) {
                return 1;
            }
            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }
}
