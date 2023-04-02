package com.jose.api.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jose.api.dto.CepDto;
import com.jose.api.dto.EnderecoDto;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class ConsultarEnderecoStepsDefinition {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private MvcResult mvcResult;
    private CepDto cepDto;

    @DataTableType
    public EnderecoDto enderecoEntryTransformer(Map<String, String> row) {
        EnderecoDto endereco = new EnderecoDto();

        endereco.setBairro(row.getOrDefault("bairro", ""));
        endereco.setCep(row.getOrDefault("cep", ""));
        endereco.setRua(row.getOrDefault("rua", ""));
        endereco.setComplemento(row.getOrDefault("complemento", ""));
        endereco.setCidade(row.getOrDefault("cidade", ""));
        endereco.setEstado(row.getOrDefault("estado", ""));
        endereco.setFrete(Double.parseDouble(row.getOrDefault("frete", "")));

        return endereco;
    }

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Given("que eu possua o CEP {string}")
    public void i_have_access_to_the_API_with_POST_method_using_URL(String cep) {
        this.cepDto = new CepDto(cep);
    }

    @When("eu chamar a rota POST {string} informando tal cep")
    public void i_make_a_POST_request_with_the_following_JSON_body(String endpoint) throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(
                new ObjectMapper().writeValueAsString(this.cepDto)
            );

        this.mvcResult = mockMvc.perform(request).andReturn();
    }

    @Then("a tabela de endereço retornada deve conter tais informacoes:")
    public void i_should_receive_a_response_with_HTTP_status(EnderecoDto expectedEnderecoDto) throws UnsupportedEncodingException, JsonProcessingException {
        String responseBody = this.mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        EnderecoDto enderecoDto = new ObjectMapper().readValue(responseBody, EnderecoDto.class);

        Assert.assertEquals(expectedEnderecoDto, enderecoDto);
    }
}
