package com.example.knublog.repository;

import com.example.knublog.domain.blog.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<Article, Long>  {
                                            //사용할 엔티티와 그 프라이머리 키

}
