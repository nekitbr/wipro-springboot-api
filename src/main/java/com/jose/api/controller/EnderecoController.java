package com.jose.api.controller;

import com.gtbr.domain.Cep;
import com.jose.api.dto.CepDto;
import com.jose.api.dto.EnderecoDto;
import com.jose.api.services.ICepService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/consulta-endereco")
@CrossOrigin
public class EnderecoController {
    @Autowired
    private ICepService cepService;

    @Operation(description = "Retorna um endereço através de um CEP")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnderecoDto> consultarEndereco(
            @Valid @RequestBody CepDto dto
    ) throws ResponseStatusException {
        String unmaskedCep = cepService.unmaskCep(dto.getCep());

        Cep cepInfo = cepService.findCep(unmaskedCep);

        if(cepInfo.getCep() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
            new EnderecoDto(cepInfo)
        );
    }
}
