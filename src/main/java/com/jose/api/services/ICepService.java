package com.jose.api.services;

import com.gtbr.domain.Cep;

public interface ICepService {
    String unmaskCep(String cep);
    Cep findCep(String cep);
}
