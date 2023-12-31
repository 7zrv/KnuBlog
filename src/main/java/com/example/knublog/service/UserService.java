package com.example.knublog.service;


import com.example.knublog.domain.user.User;
import com.example.knublog.repository.UserRepository;
import com.example.knublog.web.dto.AddUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequestDto requestDto){
        return userRepository.save(
                User.builder()
                        .email(requestDto.getEmail())
                        .password(bCryptPasswordEncoder.encode(requestDto.getPassword()))
                        .build()
        ).getId();
    }

    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("unexpected user"));
    }
}
