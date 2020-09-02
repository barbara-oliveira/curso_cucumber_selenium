package com.study.bdd.services;

import com.study.bdd.entity.Filme;
import com.study.bdd.entity.NotaDeAluguel;
import com.study.bdd.utils.DateUtil;

public class AluguelService {

    public NotaDeAluguel alugar(Filme filme, String tipo) {

        if(filme.getEstoque() == 0) {
            throw new RuntimeException("Filme sem estoque");

        }

        NotaDeAluguel nota = new NotaDeAluguel();
        if("extendido".equals(tipo)) {
            nota.setPreco(filme.getAluguel() * 2);
            nota.setDataEntrega(DateUtil.obterDataDiferencaDias(3));
            nota.setPontuacao(2);
        } else {
            nota.setDataEntrega(DateUtil.obterDataDiferencaDias(1));
            nota.setPreco(filme.getAluguel());
        }

        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
