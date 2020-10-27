package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
}
