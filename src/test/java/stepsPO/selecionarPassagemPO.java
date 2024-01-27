package stepsPO;

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
import pages.HomePage;
import pages.ReservePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class selecionarPassagemPO {
    private WebDriver driver;
    private HomePage homePage; // mapeamento dos elementos da Home
    private ReservePage reservePage; // mapeamento dos elemento da Reserve

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

        // instancia as classes de mapeamento
        homePage = new HomePage(driver);
        reservePage = new ReservePage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();

    }

    @Given("que acesso site Blazedemo PO")
    public void que_acesso_site_blazedemo_po() {
        System.out.println("Passo 1");
        driver.get("https://www.blazedemo.com");
    }
    @When("seleciono a origem como {string} e destino {string} PO")
    public void seleciono_a_origem_como_e_destino_po(String origem, String destino) {
        System.out.println("Passo 2");
        homePage.selecionarOrigemDestino(origem, destino);
    }

    @And("clico em Procurar Voo PO")
    public void clico_em_procurar_voo_po() {
        System.out.println("Passo 3");
        homePage.clicarBtnProcurarVoo();
    }
    @Then("exibe a frase indicando voo sera entre {string} e {string} PO")
    public void exibe_a_frase_indicando_voo_sera_entre_e_po(String origem, String destino) {
        System.out.println("Passo 4");
        assertEquals("Flights from " + origem + " to " + destino + ":",reservePage.lerCabecalhoListaDeVoos());
    }

}
