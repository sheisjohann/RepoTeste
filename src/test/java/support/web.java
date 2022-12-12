package support;

import utility.constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class web {

    public static WebDriver createChrome() {

        System.setProperty("webdriver.chrome.driver", "source/chromedriver.exe");
        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        navegador.get(constants.URL);
        return navegador;

    }
}
