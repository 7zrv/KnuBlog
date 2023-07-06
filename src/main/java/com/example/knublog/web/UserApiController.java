package com.example.knublog.web;


import com.example.knublog.service.UserService;
import com.example.knublog.web.dto.AddUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequestDto requestDto){
        userService.save(requestDto);

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(
                request,
                response,
                SecurityContextHolder.getContext().getAuthentication()

        );

        return "redirect:/login";
    }


}
