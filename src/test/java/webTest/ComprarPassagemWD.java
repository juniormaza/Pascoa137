// 0 - Pacote

package webTest;
// 1 - Bibliotecas


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import static org.junit.jupiter.api.Assertions.assertEquals;

// 2 - Classe
public class ComprarPassagemWD { // inicio da classe
    // 2.1 - Atributos
    private WebDriver driver; // Declaração do objeto do Selenium WebDriver

    // 2.2 - Funções e Métodos

    // Antes do Teste
    @BeforeEach
    public void setUp(){ // inicio do Before
        //WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions(); // instancia o ChromeOptions
        options.addArguments("--remote-allow-origins=*");

        // Aponta onde está o Chrome Driver
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver(options); // Instancia / Liga o chrome Driver
        driver.manage().window().maximize(); // maximixa a janela navegador


    } // fim do Before
    @AfterEach
    // Depois do Teste
    public  void tearDown(){ // inicio do After
        driver.quit(); // destroi  a instancia do Selenium WebDriver

    } // fim do After

    // O Teste
    @Test
    public void comprarPasagemWD(){ // inicio do comprarPassagem
        driver.get("https://www.blazedemo.com"); // abre o endereço alvo
        // selecionar a lista/combo de cidade de origem
        driver.findElement(By.name("fromPort")).click();
        // selecionar a cidade na lista
        { // inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        } // fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click();
        // selecionar a cidade na lista
        { // inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            lista.findElement(By.xpath("//option[. = 'Berlin']")).click();
        } // fim da seleção dentro da lista

        // apertar o botão Find Flights
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        // validar a frase que indica que o vôo é de São Paolo para Berlin
        assertEquals("Flights from São Paolo to Berlin:",driver.findElement(By.cssSelector("h3")).getText());

    } // fim do comprarPassagem


}   // fim da classe
