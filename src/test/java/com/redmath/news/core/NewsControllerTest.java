package com.redmath.news.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class NewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNewsGetAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/news?search=%e%"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testNewsGetById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/news/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testNewsPost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/news")
                .with(SecurityMockMvcRequestPostProcessors.user("reporter")
                        .authorities(new SimpleGrantedAuthority("REPORTER")))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                .contentType("application/json")
                .content("{\"title\":\"title 3\",\"details\":\"details 3\",\"tags\":\"tags 3\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/news")
                .with(SecurityMockMvcRequestPostProcessors.user("reporter")
                        .authorities(new SimpleGrantedAuthority("REPORTER")))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                .contentType("application/json")
                .content("{\"title\":\"title 3\",\"details\":\"details 3\",\"tags\":\"tags 3\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}