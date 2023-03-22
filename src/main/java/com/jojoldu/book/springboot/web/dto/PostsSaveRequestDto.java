package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;

public record PostsSaveRequestDto(
        String title,
        String content,
        String author
) {
    public static PostsSaveRequestDto of(
            String title,
            String content,
            String author
    ){
        return new PostsSaveRequestDto(title, content, author);
    }
    public Posts toPostsEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
