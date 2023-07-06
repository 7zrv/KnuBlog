package com.example.knublog.service;


import com.example.knublog.domain.blog.Article;
import com.example.knublog.repository.BlogRepository;
import com.example.knublog.web.dto.AddArticleRequest;
import com.example.knublog.web.dto.UpdateArticleRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor// 생성자 초기화 자동화
@Service
public class BlogService {

    private final BlogRepository blogRepository;
    //save
    public Article save(AddArticleRequest requestDto){
        return blogRepository.save(requestDto.toEntity());
    }

    //전체 조회

    //@Transactional(readOnly)
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    //단건 조회
    public Article findById(Long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("article not exist! : " + id));
    }

    //delete
    public void delete(Long id){
        blogRepository.deleteById(id);
    }

    //update
    @Transactional //원자성 보장
    public Article update(Long id, UpdateArticleRequestDto requestDto){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("article not exist! : " + id));

        //특정 시점에 자동으로 반영되어 db에 담는 구문이 없음
        article.update(requestDto.getTitle(), requestDto.getContent());

        return article;
    }




}
