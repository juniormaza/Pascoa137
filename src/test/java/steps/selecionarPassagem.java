package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class selecionarPassagem {
    WebDriver driver;

    @Before
    public void setup(){

        //Aponta onde está o Chrome Driver
        //System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");
        //Declara o gerenciador para baixar o chrome driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
    }

    @After
    public void tearDown(){
        driver.quit();

    }

    @Given("que acesso site Blazedemo")
    public void que_acesso_site_blazedemo() {
        System.out.println("Passo 1");
        driver.get("https://www.blazedemo.com");
    }
    @When("seleciono a origem como {string} e destino {string}")
    public void seleciono_a_origem_como_e_destino(String origem, String destino) {
        System.out.println("Passo 2");
        driver.findElement(By.name("fromPort")).click();
        // selecionar a cidade na lista
        { // inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. = '" + origem + "']")).click();
        } // fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click();
        // selecionar a cidade na lista
        { // inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            lista.findElement(By.xpath("//option[. = '" + destino + "']")).click();
        } // fim da seleção dentro da lista

    }
    @And("clico em Procurar Voo")
    public void clico_em_procurar_voo() {
        System.out.println("Passo 3");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }
    @Then("exibe a frase indicando voo sera entre {string} e {string}")
    public void exibe_a_frase_indicando_voo_sera_entre_e(String string, String string2) {
        System.out.println("Passo 4");
        assertEquals("Flights from São Paolo to Berlin:",driver.findElement(By.cssSelector("h3")).getText());
    }

}
