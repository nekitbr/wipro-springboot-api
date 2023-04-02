package com.jose.api.enums;

public enum Frete {
    SUDESTE(Regioes.SUDESTE, 7.85),
    CENTRO_OESTE(Regioes.CENTRO_OESTE, 12.50),
    NORDESTE(Regioes.NORDESTE, 15.98),
    SUL(Regioes.SUL, 17.30),
    NORTE(Regioes.NORTE, 20.83);

    private final Regioes regiao;
    private final double preco;

    Frete(Regioes regiao, double preco) {
        this.regiao = regiao;
        this.preco = preco;
    }

    public static Frete fromRegiao(final Regioes regiao) {
        for (final Frete frete : Frete.values()) {
            if (frete.regiao.equals(regiao)) {
                return frete;
            }
        }

        throw new IllegalArgumentException(regiao.toString());
    }

    public Regioes regiao() {
        return this.regiao;
    }

    public double preco() {
        return this.preco;
    }
}
