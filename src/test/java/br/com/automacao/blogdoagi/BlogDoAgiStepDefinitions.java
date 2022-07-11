package br.com.automacao.blogdoagi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BlogDoAgiStepDefinitions {

    private BlogDoAgiPageObjects blogDoAgiPageObjects;

    public BlogDoAgiStepDefinitions() {

        blogDoAgiPageObjects = new BlogDoAgiPageObjects();
    }

    @After
    public void after() {

        blogDoAgiPageObjects.fechaNavegador();
    }

    @Given("que estou no blog da agi")
    public void que_estou_no_blog_da_agi() {

        blogDoAgiPageObjects.acessarPaginaBlogDoAgi();
    }

    @Given("que clico na lupa de pesquisa")
    public void que_clico_na_lupa_de_pesquisa() {

        blogDoAgiPageObjects.clicaBtnLupa();
    }

    @When("pesquiso pelo registro {string}")
    public void pesquiso_pelo_registro(String registro) {

        blogDoAgiPageObjects.preencheCampoPesquisa(registro);
    }

    @When("clico no botão pesquisar")
    public void clico_no_botão_pesquisar() {

        blogDoAgiPageObjects.clicaBtnPesquisar();
    }

    @Then("deve retornar mensagem {string}")
    public void deve_retornar_mensagem(String mensagem) {

        blogDoAgiPageObjects.verificarResultadoPesquisaZerada(mensagem);
    }

    @Then("deve retornar registro com o título {string}")
    public void deve_retornar_registro_com_o_título(String mensagem) {

        blogDoAgiPageObjects.verificarResultadoExato(mensagem);
    }
}
