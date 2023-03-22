package com.jojoldu.book.springboot.web.dto;

public record PostsUpdateRequestDto(
        String title,
        String content
) {
    public static PostsUpdateRequestDto of(
            String title,
            String content
    ){
        return new PostsUpdateRequestDto(title, content);
    }
}
