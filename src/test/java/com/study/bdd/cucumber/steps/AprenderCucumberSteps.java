package com.study.bdd.cucumber.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class AprenderCucumberSteps {
    @Dado("que criei o arquivo corretamente")
    public void queCrieiOArquivoCorretamente() {
        //TODO
    }

    @Quando("executa-lo")
    public void executaLo() {
        //TODO
    }

    @Então("a especificacao deve finalizar com sucesso")
    public void aEspecificacaoDeveFinalizarComSucesso() {
        //TODO
    }

    int contador = 0;
    @Dado("que o valor do contador e {int}")
    public void queOValorDoContadorE(Integer int1) {
        contador = int1;
    }

    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(Integer int1) {
        contador += int1;
    }

    @Então("o valor do contador sera {int}")
    public void oValorDoContadorSera(Integer int1) {
        Assert.assertEquals( (long) int1, contador);
    }

}
