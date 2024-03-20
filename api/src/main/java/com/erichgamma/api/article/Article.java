package com.erichgamma.api.article;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Article {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String registarDate;

    @Builder(builderMethodName = "builder")

    public Article(Long id, String title, String content, String writer,String registarDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registarDate =registarDate;
    }
}
