package com.jose.api.enums;

public enum UF {
    AMAZONAS("Amazonas", "AM", "Manaus", Regioes.NORTE),
    ALAGOAS("Alagoas", "AL", "Maceió", Regioes.NORDESTE),
    ACRE("Acre", "AC", "Rio Branco", Regioes.NORTE),
    AMAPA("Amapá", "AP", "Macapá", Regioes.NORTE),
    BAHIA("Bahia", "BA", "Salvador", Regioes.NORDESTE),
    PARA("Pará", "PA", "Belém", Regioes.NORTE),
    MATO_GROSSO("Mato Grosso", "MT", "Cuiabá", Regioes.CENTRO_OESTE),
    MINAS_GERAIS("Minas Gerais", "MG", "Belo Horizonte", Regioes.SUDESTE),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", "Campo Grande", Regioes.CENTRO_OESTE),
    GOIAS("Goiás", "GO", "Goiânia", Regioes.CENTRO_OESTE),
    MARANHAO("Maranhão", "MA", "São Luís", Regioes.NORDESTE),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", "Porto Alegre", Regioes.SUL),
    TOCANTINS("Tocantins", "TO", "Palmas", Regioes.NORTE),
    PIAUI("Piauí", "PI", "Teresina", Regioes.NORDESTE),
    SAO_PAULO("São Paulo", "SP", "São Paulo", Regioes.SUDESTE),
    RONDONIA("Rondônia", "RO", "Porto Velho", Regioes.NORTE),
    RORAIMA("Roraima", "RR", "Boa Vista", Regioes.NORTE),
    PARANA("Paraná", "PR", "Curitiba", Regioes.SUL),
    CEARA("Ceará", "CE", "Fortaleza", Regioes.NORDESTE),
    PERNAMBUCO("Pernambuco", "PE", "Recife", Regioes.NORDESTE),
    SANTA_CATARINA("Santa Catarina", "SC", "Florianópolis", Regioes.SUL),
    PARAIBA("Paraíba", "PB", "João Pessoa", Regioes.NORDESTE),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", "Natal", Regioes.NORDESTE),
    ESPIRITO_SANTO("Espírito Santo", "ES", "Vitória", Regioes.SUDESTE),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Rio de Janeiro", Regioes.SUDESTE),
    SERGIPE("Sergipe", "SE", "Aracaju", Regioes.NORDESTE),
    DISTRITO_FEDERAL("Distrito Federal", "DF", "Brasília", Regioes.CENTRO_OESTE);

    private final String nome;
    private final String sigla;
    private final String capital;
    private final Regioes regiao;

    UF(final String nome, final String sigla, final String capital, final Regioes regiao) {
        this.nome = nome;
        this.sigla = sigla;
        this.capital = capital;
        this.regiao = regiao;
    }

    public static UF fromUF(final String nomeUf) {
        for (final UF uf : UF.values()) {
            if (uf.nome.equalsIgnoreCase(nomeUf)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(nomeUf);
    }

    public static UF fromSigla(final String sigla) {
        for (final UF uf : UF.values()) {
            if (uf.sigla.equalsIgnoreCase(sigla)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(sigla);
    }

    public static UF fromCapital(final String capital) {
        for (final UF uf : UF.values()) {
            if (uf.capital.equalsIgnoreCase(capital)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(capital);
    }

    public String sigla() {
        return this.sigla;
    }

    public String nome() {
        return this.nome;
    }

    public String capital() {
        return this.capital;
    }

    public Regioes regiao() {
        return this.regiao;
    }
}