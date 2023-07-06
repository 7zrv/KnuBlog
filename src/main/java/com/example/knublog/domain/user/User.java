package com.example.knublog.domain.user;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "users")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;


    @Builder
    public User(String email, String password, String auth) {
        this.email = email;
        this.password = password;
    }


    //userDetails overriding method
    @Override
    //권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    //사용자 아이디 반환 여기서는 email
    public String getUsername() {
        return email;
    }

    @Override
    // 계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        //만료되었는지 확인 true면 만료 안됨
        return true;
    }

    @Override
    //계정 잠금 여부 반환
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //비밀번호 만료 여부 반환
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //계정 사용가능 여부
    public boolean isEnabled() {
        return true;
    }
}
