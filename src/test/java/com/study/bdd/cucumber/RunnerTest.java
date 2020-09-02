package com.study.bdd.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/inserir_conta.feature",
        plugin = {"pretty", "html:target/report.html"},
        monochrome = false,
        snippets = CAMELCASE,
        tags = "not @ignore"
)
public class RunnerTest {
}
