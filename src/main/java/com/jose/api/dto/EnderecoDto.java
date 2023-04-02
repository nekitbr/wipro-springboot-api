package com.jose.api.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtbr.domain.Cep;
import com.jose.api.enums.Frete;
import com.jose.api.enums.UF;
import lombok.Data;

@Data
public class EnderecoDto {
    String cep;
    String rua;
    String complemento;
    String bairro;
    String cidade;
    String estado;
    double frete;

    public EnderecoDto() {}

    public EnderecoDto(Cep viaCepResponse) {
        this.cep = viaCepResponse.getCep();
        this.rua = viaCepResponse.getLogradouro();
        this.complemento = viaCepResponse.getComplemento();
        this.bairro = viaCepResponse.getBairro();
        this.cidade = viaCepResponse.getLocalidade();
        this.estado = viaCepResponse.getUf();
        this.frete = Frete.fromRegiao(UF.fromSigla(viaCepResponse.getUf()).regiao()).preco();
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
