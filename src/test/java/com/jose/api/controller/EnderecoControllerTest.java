package com.jose.api.controller;

import com.jose.api.dto.CepDto;
import com.jose.api.dto.EnderecoDto;
import com.jose.api.enums.Frete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
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
        commonRequest.content(new CepDto("01001000").toJson());

        EnderecoDto expectedEnderecoDto = new EnderecoDto();
        expectedEnderecoDto.setBairro("Sé");
        expectedEnderecoDto.setCep("01001-000");
        expectedEnderecoDto.setRua("Praça da Sé");
        expectedEnderecoDto.setComplemento("lado ímpar");
        expectedEnderecoDto.setCidade("São Paulo");
        expectedEnderecoDto.setEstado("SP");
        expectedEnderecoDto.setFrete(Frete.SUDESTE.preco());

        this.mvc
            .perform(commonRequest)
            .andExpectAll(
                status().is(200),
                content().json(expectedEnderecoDto.toJson())
            );
    }

    @Test
    @DisplayName("should return 400 for invalid cep format")
    public void tooManyCharacters() throws Exception {
        commonRequest.content(new CepDto("010010001").toJson());

        this.mvc
            .perform(commonRequest)
            .andExpect(
                MockMvcResultMatchers.status().is(400)
            );
    }

    @Test
    @DisplayName("should return 404 for not found")
    public void cepWithLetters() throws Exception {
        commonRequest.content(new CepDto("12345612").toJson());

        this.mvc
            .perform(commonRequest)
            .andExpect(
                MockMvcResultMatchers.status().is(404)
            );
    }
}
