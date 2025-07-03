package poo.calculadora;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double resultado;
        System.out.println("Informe o primeiro número.");
        double numero1 = scanner.nextDouble();
        System.out.println("Informe o segundo número.");
        double numero2 = scanner.nextDouble();
        System.out.println("Informe a operação: +|-|*|/");
        String operacao = scanner.next();

        switch (operacao) {
            case "+":
                resultado = somar(numero1, numero2);
                System.out.println("Resultado: " + resultado);
                break;
            case "-":
                resultado = subtrair(numero1, numero2);
                System.out.println("Resultado: " + resultado);
                break;
            case "*":
                resultado = multiplicar(numero1, numero2);
                System.out.println("Resultado: " + resultado);
                break;
            case "/":
                if(numero2 == 0){
                    System.out.println("Não é possível dividir por zero.");
                }else{
                    resultado = dividir(numero1, numero2);
                    System.out.println("Resultado: " + resultado);
                }
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        scanner.close();

    }

    public static double somar(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtrair(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public static double dividir(double num1, double num2) {
        return num1 / num2;
    }


}
