package br.com.automacao.blogdoagi;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )

@CucumberOptions( features = "classpath:/blogdoagi",  glue = {"br.com.automacao.blogdoagi",
        "br.com.automacao.blogdoagi.hooks"}, plugin = {
        "pretty",
        "json:target/cucumber" } )
public class RunCucumber {

}