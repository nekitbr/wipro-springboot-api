package com.jose.api.controller;

import com.gtbr.ViaCepClient;
import com.gtbr.domain.Cep;
import com.gtbr.utils.CEPUtils;
import com.jose.api.dto.controllers.EnderecoController.ConsultarEnderecoRequest;
import com.jose.api.dto.controllers.EnderecoController.ConsultarEnderecoResponse;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/consulta-endereco")
public class EnderecoController {
    @Value("server.servlet.context-path")
    private String API_BASE;

    @PostMapping
    public ConsultarEnderecoResponse consultarEndereco(
            @Valid @RequestBody ConsultarEnderecoRequest body
    ) {
        String unmaskedCep = CEPUtils.removeMascaraCep(body.getCep());

        if(!NumberUtils.isParsable(unmaskedCep)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Field cep must have numbers only.");
        }

        if (unmaskedCep.length() > 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Field cep has too many characters.");
        }

        Cep cepInfo = ViaCepClient.findCep(unmaskedCep);

        if(cepInfo.getCep() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address info for given cep was not found.");
        }

        return new ConsultarEnderecoResponse(cepInfo);
    }
}
