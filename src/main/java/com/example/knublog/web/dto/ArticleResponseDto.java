package com.example.knublog.web.dto;


import com.example.knublog.domain.blog.Article;
import lombok.Getter;

@Getter
public class ArticleResponseDto {

    private String title;
    private String content;

    //request와 다름

    public ArticleResponseDto(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
