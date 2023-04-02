package com.jose.api.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CepDto {
    @NotBlank(message = "Field cep must not be empty.")
    @Pattern(regexp = "^[0-9]{5}-?[0-9]{3}$", message = "Invalid CEP format.")
    String cep;

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
