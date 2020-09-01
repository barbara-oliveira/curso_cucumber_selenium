package com.study.bdd.cucumber.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class AprenderCucumberSteps {
    @Dado("que criei o arquivo corretamente")
    public void queCrieiOArquivoCorretamente() {
    }

    @Quando("executa-lo")
    public void executaLo() {
    }

    @Então("a especificação deve finalizar com sucesso")
    public void aEspecificaçãoDeveFinalizarComSucesso() {
    }

    int contador = 0;
    @Dado("que o valor do contador é {int}")
    public void que_o_valor_do_contador_é(Integer int1) {
        contador = int1;
    }

    @Quando("eu incrementar em {int}")
    public void eu_incrementar_em(Integer int1) {
        contador += int1;
    }

    @Então("o valor do contador será {int}")
    public void o_valor_do_contador_será(Integer int1) {
        Assert.assertEquals( (long) int1, contador);
    }

}
