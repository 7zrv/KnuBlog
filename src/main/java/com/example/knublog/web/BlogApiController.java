package com.example.knublog.web;


import com.example.knublog.domain.blog.Article;
import com.example.knublog.service.BlogService;
import com.example.knublog.web.dto.AddArticleRequest;
import com.example.knublog.web.dto.ArticleResponseDto;
import com.example.knublog.web.dto.UpdateArticleRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/latest/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(blogService.save(requestDto));
    }


    //all 조회
    @GetMapping("/api/latest/articles")
    public ResponseEntity<List<ArticleResponseDto>> findAllArticles(){

        List<ArticleResponseDto> articles = blogService.findAll()
                .stream()
                .map(ArticleResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(articles);

    }

    //단건 조회
    @GetMapping("/api/latest/articles/{id}")
    public ResponseEntity<ArticleResponseDto> findArticle(@PathVariable Long id){
        return ResponseEntity.ok()
                .body(new ArticleResponseDto(blogService.findById(id)));
    }

    @DeleteMapping("/api/latest/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }


    @PutMapping("/api/latest/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id,
                                                 @RequestBody UpdateArticleRequestDto requestDto){
        Article updatedArticle = blogService.update(id, requestDto);

        return ResponseEntity.ok().body(updatedArticle);

    }
}
