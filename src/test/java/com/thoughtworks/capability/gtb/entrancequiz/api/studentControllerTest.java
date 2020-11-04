package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//TODO GTB-工程实践: - class name 首字要母大写！
//TODO GTB-测试: + 有两个 tests，测试了默认学员数量 和 添加学员

@SpringBootTest
@AutoConfigureMockMvc
public class studentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_get_all_student_list() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect (jsonPath("$", hasSize(15)))
                .andExpect(status().isOk());
    }

    @Test
    public void should_add_student() throws Exception {
        String jsonString = "{\"id\":15, \"name\":\"甄姬\"}";
        mockMvc.perform(post("/students").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(16)))
                //TODO GTB-知识点: - 应该是 CREATED，而不是 OK
                .andExpect(status().isOk());
    }
}
