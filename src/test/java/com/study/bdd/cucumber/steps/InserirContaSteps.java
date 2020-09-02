package com.study.bdd.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContaSteps {

    private static final String MENSAGEM_SUCESSO_LOGIN = "Bem vindo, Bárbara Oliveira da Silva!";
    private static final String CONTA_ADICIONADA_COM_SUCESSO = "Conta adicionada com sucesso!";
    public static final String INFORME_O_NOME_DA_CONTA = "Informe o nome da conta";
    public static final String ERRO_CONTA_JA_CADASTRADA = "Já existe uma conta com esse nome!";
    private WebDriver driver;

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        System.setProperty("webdriver.chrome.driver", "/home/barbara/Downloads/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://srbarriga.herokuapp.com/");
    }

    @Quando("informo o usuário {word}")
    public void informoOUsuárioBarbaraOliveiraSilvaTesteCom(String usuario) {
        driver.findElement(By.id("email")).sendKeys(usuario);
    }

    @Quando("a senha {word}")
    public void aSenhaSenha123(String senha) {
        driver.findElement(By.name("senha")).sendKeys(senha);
    }

    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        String mensagemSucesso = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals(MENSAGEM_SUCESSO_LOGIN,mensagemSucesso);
    }
    @Quando("seleciono Contas")
    public void selecionoContas() {
        driver.findElement(By.linkText("Contas")).click();
    }

    @Quando("seleciono Adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("informo a conta {string}")
    public void informoAConta(String string) {
        driver.findElement(By.id("nome")).sendKeys(string);
    }

    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("a conta é inserida com sucesso")
    public void aContaÉInseridaComSucesso() {
        String mensagemSucesso = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals(CONTA_ADICIONADA_COM_SUCESSO, mensagemSucesso);
    }

    @Então("sou notificado que o nome da conta é obrigatório")
    public void souNotificadoQueONomeDaContaÉObrigatório() {
        String mensagemErro = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals(INFORME_O_NOME_DA_CONTA, mensagemErro);
    }

    @Então("sou notificado que já existe uma conta com esse nome")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
        String mensagemErro = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals(ERRO_CONTA_JA_CADASTRADA, mensagemErro);
    }

    @After
    public void fecharBrowser() {
        driver.quit();
    }
}
