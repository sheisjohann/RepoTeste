package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.constants;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ValidarPesquisa {

    private WebDriver navegador; // atributo para ser usado em tds os metodos

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "src/chrome/chromedriver.exe");
         navegador = new ChromeDriver();

        navegador.get(constants.URL);
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

    }

    @Test
    public void testValidarPesquisarComDadoValido(){
        navegador.findElement(By.id("search-open")). click();

        WebElement DesktopSearch = navegador.findElement(By.className("search-form"));
        DesktopSearch.findElement(By.className("search-field")).sendKeys(constants.PalavraTeste);
        navegador.findElement(By.className("search-submit")).click();

        WebElement text = navegador.findElement(By.cssSelector("#primary > header > h1 > span"));
        String textElement = text.getText();
        assertEquals(constants.PalavraTeste, textElement);

    }
    @Test
    public void testValidarPesquisarComDadoInvalido(){
        navegador.findElement(By.id("search-open")). click();

        WebElement DesktopSearch = navegador.findElement(By.className("search-form"));
        DesktopSearch.findElement(By.className("search-field")).sendKeys(constants.NenhumResultado);
        navegador.findElement(By.className("search-submit")).click();

        WebElement text = navegador.findElement(By.cssSelector("#primary > section > header > h1"));
        String textElement = text.getText();
        assertEquals(constants.FraseResultado, textElement);
        //navegador.quit();

    }

    @Test
    public void testValidarPesquisarSemDado() {

        navegador.findElement(By.id("search-open")).click();

        WebElement DesktopSearch = navegador.findElement(By.className("search-form"));
        DesktopSearch.findElement(By.className("search-field"));
        navegador.findElement(By.className("search-submit")).click();

        WebElement text = navegador.findElement(By.cssSelector("#primary > header > h1 > span"));
        String textNoElement = text.getText();
        assertEquals("", textNoElement);
      //  navegador.quit();

    }

       @After
        public void tearDown() {
        navegador.quit();
    }

}
