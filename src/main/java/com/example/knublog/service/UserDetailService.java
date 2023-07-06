package com.example.knublog.service;


import com.example.knublog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //실제 인증된 사용자 불러와서 securitycontext에서 관리 해줘야함
//        System.out.println("email = " + email);
//        System.out.println(userRepository.findByEmail(email).get().getPassword());

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("ddd" + email));
    }
}
