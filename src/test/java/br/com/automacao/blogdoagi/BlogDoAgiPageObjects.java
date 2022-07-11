package br.com.automacao.blogdoagi;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;

public class BlogDoAgiPageObjects {

    private static WebDriver driver;

    private static WebDriverWait wait;

    private static final By btnLupa = By.xpath(".//*[@id='search-open']");

    private static final By campoPesquisa = By.xpath(".//*[@class='search-field']");

    private static final By btnPesquisar = By.xpath(".//*[@class='search-submit']");

    private static final By resultadoPesquisaZerada = By.xpath(".//*[@class='entry-content']");

    private static final By resultadoExato = By.xpath(".//*[@class='entry-title']");

    public BlogDoAgiPageObjects() {
        //Copiar Absolute Path
        System.setProperty("webdriver.chrome.driver",
                "/home/mtuser/Downloads/automacao/src/test/resources/drivers/linux/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acessarPaginaBlogDoAgi() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://blogdoagi.com.br/");
    }

    public void fechaNavegador() {

        driver.close();
    }

    public void clicaBtnLupa() {

        wait.until(ExpectedConditions.elementToBeClickable(btnLupa));
        driver.findElement(btnLupa).click();
    }

    public void preencheCampoPesquisa(String dado) {

        wait.until(ExpectedConditions.presenceOfElementLocated(campoPesquisa));
        driver.findElement(campoPesquisa).sendKeys(dado);
    }

    public void clicaBtnPesquisar() {

        wait.until(ExpectedConditions.elementToBeClickable(btnPesquisar));
        driver.findElement(btnPesquisar).click();
    }

    public void verificarResultadoPesquisaZerada(String dado) {

        String valormensagem = driver.findElement(resultadoPesquisaZerada).getText();
        Assert.assertEquals(dado, valormensagem);
        printLogs(dado, valormensagem);
    }

    public void verificarResultadoExato(String dado) {

        String valormensagem = driver.findElement(resultadoExato).getText();
        Assert.assertEquals(dado, valormensagem);
        printLogs(dado, valormensagem);
    }

    public void printLogs(String dado, String valormensagem) {

        System.out.println("Validado mensagem esperada:" + dado + "\n Retornada:" + valormensagem);
    }
}
