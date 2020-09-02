package com.study.bdd.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/alugar_filme.feature",
        plugin = "pretty",
        monochrome = false,
        snippets = CAMELCASE,
        tags = "not @ignore"
)
public class RunnerTest {
}
