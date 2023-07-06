package com.example.knublog.service;


import com.example.knublog.config.jwt.TokenProvider;
import com.example.knublog.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;


@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken){
        //유효성 검사 실패시 예외발생
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalStateException("unexpected token!");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));

    }

    //최초 유저인증

    //리프레쉬 토큰 expired일 때 재발급

}
