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

    @Então("recebo a mensagem {string}")
    public void receboAMensagem(String string) {
        String mensagem = driver.findElement(By.xpath("//div[starts-with(@class,'alert alert-')]")).getText();
        Assert.assertEquals(string, mensagem);
    }

    @After
    public void fecharBrowser() {
        driver.quit();
    }
}
