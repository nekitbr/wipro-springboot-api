package com.jose.api.tdd.controller;

import com.jose.api.dto.controllers.EnderecoController.ConsultarEnderecoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class EnderecoControllerTest {

    @Autowired
    MockMvc mvc;

    private MockHttpServletRequestBuilder commonRequest;

    @BeforeEach
    public void init() {
        this.commonRequest = MockMvcRequestBuilders
                .post("/consulta-endereco")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    @Test
    @DisplayName("should return 200 with valid address")
    public void returnCEPAddress() throws Exception {
        commonRequest.content(new ConsultarEnderecoRequest("01001000").toJson());

        mvc.perform(commonRequest).andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @DisplayName("should return 400 for invalid cep format")
    public void tooManyCharacters() throws Exception {
        commonRequest.content(new ConsultarEnderecoRequest("010010001").toJson());

        this.mvc.perform(commonRequest).andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @DisplayName("should return 404 for not found")
    public void cepWithLetters() throws Exception {
        commonRequest.content(new ConsultarEnderecoRequest("12345612").toJson());

        this.mvc.perform(commonRequest).andExpect(MockMvcResultMatchers.status().is(404));
    }
}
