package com.jose.api.controller;

import com.gtbr.domain.Cep;
import com.jose.api.dto.CepDto;
import com.jose.api.dto.EnderecoDto;
import com.jose.api.exceptions.NotFoundException;
import com.jose.api.services.ICepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
 
import javax.validation.Valid;

@RestController
@RequestMapping("/consulta-endereco")
@CrossOrigin
@Tag(name = "Endereço", description = "API para consulta de endereços")
public class EnderecoController {
    @Autowired
    private ICepService cepService;

    @Operation(summary = "Consultar endereço por CEP", description = "Retorna informações de endereço para um CEP fornecido.")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnderecoDto> consultarEndereco(
        @Valid @RequestBody CepDto dto
    ) {
        String unmaskedCep = cepService.unmaskCep(dto.getCep());

        Cep cepInfo = cepService.findCep(unmaskedCep);

        if(cepInfo.getCep() == null) {
            throw new NotFoundException("CEP não encontrado.");
        }

        return ResponseEntity.ok(
            new EnderecoDto(cepInfo)
        );
    }
}
