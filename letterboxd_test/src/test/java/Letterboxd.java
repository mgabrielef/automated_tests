import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Letterboxd {

    private WebDriver driver;

    @Before
    public void abrir(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\maria\\Downloads\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window();
        driver.get("https://letterboxd.com/");
    }

    @After
    public void sair(){
        driver.quit();
    }


    @Test
    public void abrirSite() {
        Assert.assertEquals("Letterboxd • Social film discovery.", driver.getTitle());
    }

    @Test
    public void pesquisar(){
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//*[@id=\"search-q\"]")).sendKeys("Dead Poets Society");
        driver.findElement(By.xpath("/html/body/header/section/form[2]/fieldset/input[2]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"search-filter\"]/ul/li[1]/a")).getText().contains("All"));

    }

    @Test
    public void abrirFilme(){
        driver.findElement(By.xpath("//*[@id=\"search-q\"]")).sendKeys("Dead Poets Society");
        driver.findElement(By.xpath("/html/body/header/section/form[2]/fieldset/input[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/ul/li[1]/div[2]/h2/span/a")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"featured-film-header\"]/p")).getText().contains(" Directed by "));
    }
}



