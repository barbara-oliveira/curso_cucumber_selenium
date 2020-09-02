package com.study.bdd.cucumber.steps;

import com.study.bdd.entity.Filme;
import com.study.bdd.entity.NotaDeAluguel;
import com.study.bdd.services.AluguelService;
import com.study.bdd.utils.DateUtil;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {

    public static final String FILME_SEM_ESTOQUE = "Filme sem estoque";
    private Filme filme;
    private AluguelService aluguel = new AluguelService();;
    private NotaDeAluguel nota;
    private String erro;
    private String tipoAluguel;

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Dado("que o preco do aluguel seja R$ {int}")
    public void queOPrecoDoAluguelSejaR$(Integer int1) {
        filme.setAluguel(int1);
    }

    @Quando("alugar")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Entao("o preco do aluguel sera R$ {int}")
    public void oPrecoDoAluguelSeraR$(Integer int1) {
        Assert.assertEquals( (long) int1, nota.getPreco());
    }

    @Entao("a data de entrega sera no dia seguinte")
    public void aDataDeEntregaSeraNoDiaSeguinte() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = nota.getDataEntrega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
        Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
    }

    @Entao("o estoque do filme sera {int}")
    public void oEstoqueDoFilmeSera(Integer int1) {
        Assert.assertEquals(filme.getEstoque(), (long) int1);
    }

    @Entao("nao sera possivel por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() {
        Assert.assertEquals(FILME_SEM_ESTOQUE, erro);
    }

    @Dado("que o tipo do aluguel seja {word}")
    public void queOTipoDoAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo;
    }

    @Então("a data de entrega sera em {int} (dias|dia)")
    public void aDataDeEntregaSeraEmDias(Integer int1) {
        Date dataEsperada = DateUtil.obterDataDiferencaDias(int1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("a pontuacao sera de {int} pontos")
    public void aPontuacaoSeraDePontos(Integer int1) {
        Assert.assertEquals( (long) int1, nota.getPontuacao());
    }


}
