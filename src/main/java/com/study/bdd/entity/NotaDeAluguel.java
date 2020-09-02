package com.study.bdd.entity;

import java.util.Date;

public class NotaDeAluguel {

    private int preco;
    private Date dataEntrega;
    private int pontuacao;

    public int getPreco() {
        return this.preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Date getDataEntrega() {
        return this.dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }
}
