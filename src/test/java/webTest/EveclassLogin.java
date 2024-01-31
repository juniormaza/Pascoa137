package webTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EveclassLogin {
    // Atributos

    WebDriver driver;
    WebDriverWait wait; // objeto de espera

    // Antes do Teste
    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));

        // Declarar o objeto de espera explicita
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));

    }

    // Depois do Teste
    @AfterEach
    public void tearDown(){
        //driver.quit();
    }

    // Testes
    @Test
    public void testeLogin() throws InterruptedException {
        driver.get("https://testando.eveclass.com");
        driver.findElement(By.id("support-action")).click();

        // Este é um caso de "Programação exótica
        driver.navigate().refresh(); // atualizar página

        // Mudança de página - carregar uma nova página
        // É como alfinete - ajuda, mas deve ser removido
        // Thread.sleep(5000); // Espere por 5 segundos

        // No lugar do Thead.sleep, devemos usar uma espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".auth-header h1")));

        // Preencher os dados de e-mail e senha
        driver.findElement(By.cssSelector("[id^='email-i-']")).sendKeys(Keys.chord("amarildo_137@yopmail.com"));
        driver.findElement(By.cssSelector("[id^='senha-i-']")).sendKeys("@marildo");

        // Clicar no botão Entrar
        driver.findElement(By.cssSelector("button[type='submit']")).click();


        // Transição de tela, pode precisar de um novo wait


        // Este é um caso de "Programação exótica
        driver.navigate().refresh(); // atualizar página

        // Validação e clique no botão Voltar
        assertEquals("Voltar",driver.findElement(By.cssSelector("a.btn-topbar")).getText());
        driver.findElement(By.cssSelector("a.btn-topbar")).click();


        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
