package com.example.knublog.config.jwt;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt") //yml을 참조해라
public class JwtProperties {
    private String issuer;
    private String secret;
}
