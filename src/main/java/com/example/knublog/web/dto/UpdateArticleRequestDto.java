package com.example.knublog.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateArticleRequestDto {

    private String title;
    private String content;



}
