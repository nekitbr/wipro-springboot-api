package com.jose.api.dto.enums;

public enum Regioes {
    NORTE,
    NORDESTE,
    SUL,
    SUDESTE,
    CENTRO_OESTE;

    @Override
    public String toString() {
        return "Regioes." + this.name();
    }
}
