package com.jose.api.dto.controllers.EnderecoController;

import com.gtbr.domain.Cep;
import com.jose.api.dto.enums.Frete;
import com.jose.api.dto.enums.UF;

public class ConsultarEnderecoResponse {
    String cep;
    String rua;
    String complemento;
    String bairro;
    String cidade;
    String estado;
    double frete;

    String erro;

    public ConsultarEnderecoResponse(String errorMessage) {
        this.erro = errorMessage;
    }

    public ConsultarEnderecoResponse(Cep viaCepResponse) {
        this.cep = viaCepResponse.getCep();
        this.rua = viaCepResponse.getLogradouro();
        this.complemento = viaCepResponse.getComplemento();
        this.bairro = viaCepResponse.getBairro();
        this.cidade = viaCepResponse.getLocalidade();
        this.estado = viaCepResponse.getUf();
        this.frete = Frete.fromRegiao(UF.fromSigla(viaCepResponse.getUf()).regiao()).preco();
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public double getFrete() {
        return frete;
    }
}
