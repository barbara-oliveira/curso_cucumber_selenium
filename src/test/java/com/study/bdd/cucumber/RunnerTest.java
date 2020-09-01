package com.study.bdd.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/aprender_cucumber.feature",
        plugin = "pretty",
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "not @ignore"
)
public class RunnerTest {
}
