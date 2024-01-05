// 1 - Pacote: conjunto de classes
package br.com.iterasys;

// 2 - Bibliotecas

// 3 - Classe
public class Calculadora {
    // 3.1 Atributos - Cracteristicas - Campos

    // 3.2 Funções e Métodos
    public static double somarDoisNumeros(double num1, double num2){
        return num1 + num2;
    }

    public static double subtrairDoisNumeros(double num1, double num2){
        return num1 - num2;
    }

    public static double multiplicarDoisNumeros(double num1, double num2){
        return num1 * num2;
    }

    public static double dividirDoisNumeros(double num1, double num2) {
        try{
            if (num1/num2 <Double.MAX_VALUE && num1/num2 > Double.MIN_VALUE){
                return num1 / num2;
            } else {
                System.out.println("Não foi possivel dividir por zero!");
                return 0;
            }
        }
        catch (RuntimeException e){
            System.out.println("Não foi possivel dividir por zero");
            return 0;
        }

    }

}
