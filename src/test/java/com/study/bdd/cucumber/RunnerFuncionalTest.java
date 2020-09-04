package com.study.bdd.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/",
        plugin = {"pretty", "html:target/report.html"},
        monochrome = false,
        snippets = CAMELCASE,
        tags = "@funcionais"
)
public class RunnerFuncionalTest {

    @BeforeClass
    public static void reset(){
        System.setProperty("webdriver.chrome.driver", "/home/barbara/Downloads/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://srbarriga.herokuapp.com/");
        driver.findElement(By.id("email")).sendKeys("barbara-oliveira-silva-19@teste.com");
        driver.findElement(By.name("senha")).sendKeys("senha123");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
