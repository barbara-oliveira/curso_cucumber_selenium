package com.study.bdd.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class InserirContaSteps {

    private WebDriver driver;

    @Dado("que desejo adicionar uma conta")
    public void que_desejo_adicionar_uma_conta() {
        System.setProperty("webdriver.chrome.driver", "/home/barbara/Downloads/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://srbarriga.herokuapp.com/");
        driver.findElement(By.id("email")).sendKeys("barbara-oliveira-silva-19@teste.com");
        driver.findElement(By.name("senha")).sendKeys("senha123");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("adiciono a conta {string}")
    public void adiciono_a_conta(String string) {
        driver.findElement(By.id("nome")).sendKeys(string);
        driver.findElement(By.tagName("button")).click();
    }

    @Então("recebo a mensagem {string}")
    public void receboAMensagem(String string) {
        String mensagem = driver.findElement(By.xpath("//div[starts-with(@class,'alert alert-')]")).getText();
        Assert.assertEquals(string, mensagem);
    }

    @After(order = 1, value = "@funcionais")
    public void screenshot(Scenario cenario) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
    }

    @After(order = 0, value = "@funcionais")
    public void fecharBrowser() {
        driver.quit();
    }
}
