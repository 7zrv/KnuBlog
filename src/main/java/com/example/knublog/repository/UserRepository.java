package com.example.knublog.repository;


import com.example.knublog.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //이메일 방식 회원조회
    Optional<User> findByEmail (String email);

}
