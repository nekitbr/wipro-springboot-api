package com.jose.api.services.impl;

import com.gtbr.ViaCepClient;
import com.gtbr.domain.Cep;
import com.gtbr.utils.CEPUtils;
import com.jose.api.services.ICepService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

@Service
public class CepService implements ICepService {
    public String unmaskCep(String cep) {
        return CEPUtils.removeMascaraCep(cep);
    }

    public Cep findCep(String cep) {
        return ViaCepClient.findCep(cep);
    }
}
