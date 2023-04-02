package com.jose.api.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CepDto {
    @Schema(description = "CEP no formato 00000-000", example = "01001000")
    @NotBlank(message = "Field cep must not be empty.")
    @Pattern(regexp = "^[0-9]{5}-?[0-9]{3}$", message = "Invalid CEP format.")
    String cep;

    public CepDto() {}
    public CepDto(String cep) {
        this.cep = cep;
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
