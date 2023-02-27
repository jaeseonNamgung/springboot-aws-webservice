package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void hello가_리턴된다() throws Exception{
        // given
        String hello = "hello";
        // when&then
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다()throws Exception{
        // given
        String name = "hello";
        int amount = 1000;
        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        // then
        mvc.perform(
                get("/hello/dto")
                        .queryParam("name", name)
                        .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));
    }

}