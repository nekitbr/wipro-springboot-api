package com.jose.api.dto.controllers.EnderecoController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jose.api.dto.controllers.ValidatedDTO;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class ConsultarEnderecoRequest extends ValidatedDTO<ConsultarEnderecoRequest> {
    @NotBlank(message = "Field cep must not be empty.")
    @Length(min = 8, max = 9, message = "Field cep needs to have 8 characters.")
    String cep;

    public ConsultarEnderecoRequest(String cep) {
        super();
        this.cep = cep;
        this.validate(this);
    }

    public ConsultarEnderecoRequest() {
        super();
        this.validate(this);
    }

    public String getCep() {
        return this.cep;
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
