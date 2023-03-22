package com.jojoldu.book.springboot.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기()throws Exception{
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author("sunnamgung8@naver.com")
                        .build());
        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        assertThat(postsList).extracting("title").containsExactly(title);
        assertThat(postsList).extracting("content").containsExactly(content);
        assertThat(postsList).extracting("author").containsExactly("sunnamgung8@naver.com");
    }

    @Test
    public void BaseTimeEntity_등록()throws Exception{
        // given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(
                Posts.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                        .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll();
        // then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>> createdDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}