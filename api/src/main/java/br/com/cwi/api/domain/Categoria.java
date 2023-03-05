package br.com.cwi.api.domain;

public enum Categoria {

    OURO(5),
    PRATA(3),
    BRONZE(2);

    private int prazoParaDevolucao;

    Categoria(int prazoParaDevolucao) {
        this.prazoParaDevolucao = prazoParaDevolucao;
    }

    public int getPrazoParaDevolucao(){
        return prazoParaDevolucao;
    }
}
