package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.posts.Posts;

import java.time.LocalDateTime;

public record PostsListResponseDto(
        Long id,
        String title,
        String author,
        LocalDateTime modifiedDate
) {
    public static PostsListResponseDto of(
            Long id,
            String title,
            String author,
            LocalDateTime modifiedDate
    ){
        return new PostsListResponseDto(id, title, author, modifiedDate);
    }

    public static PostsListResponseDto fromEntity(Posts posts){
        return PostsListResponseDto.of(
                posts.getId(),
                posts.getTitle(),
                posts.getAuthor(),
                posts.getModifiedDate()
        );
    }
}
