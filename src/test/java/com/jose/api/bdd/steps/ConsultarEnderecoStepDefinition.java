package com.jose.api.bdd.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jose.api.ApiApplication;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApiApplication.class)
@WebAppConfiguration
public class ConsultarEnderecoStepDefinition {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private MvcResult mvcResult;
    private MockHttpServletRequestBuilder commonRequest;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Given("I have access to the API with POST method using URL {word}")
    public void i_have_access_to_the_API_with_POST_method_using_URL(String url) {
        this.commonRequest = MockMvcRequestBuilders
                .post("/consulta-endereco")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    @When("I make a POST request with the following JSON body:")
    public void i_make_a_POST_request_with_the_following_JSON_body(Map<String, String> requestBody) throws Exception {
        String requestJson = new ObjectMapper().writeValueAsString(requestBody);
        mvcResult = mockMvc.perform(commonRequest.content(requestJson)).andReturn();
    }

    @Then("I should receive a response with HTTP status {int}")
    public void i_should_receive_a_response_with_HTTP_status(int statusCode) {
        MatcherAssert.assertThat(mvcResult.getResponse().getStatus(), equalTo(statusCode));
    }
}
