package unitTest;
// Bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


// Classe
public class TesteCalculadora {
    // Atributos

    // Funcões e Métodos

    @Test
    public void testeSomarDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 12;

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    // Teste de unidade data driven
    @ParameterizedTest
    @CsvSource(value = {
            "7, 5, 12.0",
            "56, 44, 100.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0"
    }, delimiter = ',')
    public void testeSomarDoisNumerosLendoLista(String txtNum1, String txtNum2, String resultadoEsperado){
        // Configura
        // Os dados de entrada e o resultado esperado vem da lista

        // Valores de entrada

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    // Teste de unidade data driven
   @ParameterizedTest
   @CsvFileSource (resources = "csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeSomarDoisNumerosLendoArquivo(String txtNum1, String txtNum2, String resultadoEsperado){
        // Configura
        // Os dados de entrada e o resultado esperado vem da lista

        // Valores de entrada

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }


    @Test
    public void testeSubtrairDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 30;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 25;

        // Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void testeMultiplicarDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 1000;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 5000;

        // Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void testeDividirDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 1000000;
        double num2 = 10;
        // Valores de saída
        double resultadoEsperado = 100000;

        // Executa
        double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void testeDivisaoPorZero(){
        // Configura
        // Valores de entrada
        double num1 = 8;
        double num2 = 0;
        String resultadoEsperado = "0.0";
        // Executa
        String resultadoAtual = String.valueOf(Calculadora.dividirDoisNumeros(num1, num2));

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
}
