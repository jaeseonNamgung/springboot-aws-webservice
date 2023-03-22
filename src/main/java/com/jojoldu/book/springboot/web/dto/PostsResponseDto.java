package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;

public record PostsResponseDto(
        Long id,
        String title,
        String content,
        String author
) {
    public static PostsResponseDto of(
            Long id,
            String title,
            String content,
            String author
    ){
        return new PostsResponseDto(id, title, content, author);
    }
    public static PostsResponseDto of(
            String title,
            String content
    ){
        return PostsResponseDto.of(null, title, content, null);
    }

    public static PostsResponseDto fromDto(Posts posts) {
        return PostsResponseDto.of(
                posts.getId(),
                posts.getTitle(),
                posts.getContent(),
                posts.getAuthor()
        );
    }
}
