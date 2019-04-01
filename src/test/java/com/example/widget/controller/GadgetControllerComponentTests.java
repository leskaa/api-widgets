package com.example.widget.controller;

import com.example.widget.domain.GadgetEntity;
import com.example.widget.dto.GadgetResponse;
import com.example.widget.repository.GadgetRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class GadgetControllerComponentTests {
    @Autowired
    private GadgetRepository gadgetRepository;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void FindAll() throws Exception {
        GadgetEntity gadget = this.gadgetRepository.save(new GadgetEntity("Cool fake gadget", 1L));

        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/gadgets"))
                .andExpect(status().isOk()).andReturn().getResponse();

        List<GadgetResponse> gadgetResponseList = mapper.readValue(response.getContentAsString(), new TypeReference<List<GadgetResponse>>() {
        });

        assertThat(gadgetResponseList.size(), equalTo(1));
        assertThat(gadgetResponseList.get(0).getName(), equalTo(gadget.getName()));
    }
}
