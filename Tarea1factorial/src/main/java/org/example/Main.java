package org.example;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        int numero=100;
        Object[] resIterativo = factorial(numero);
        System.out.println(" Lineal (N = " + numero + ") ");
        System.out.println("Resultado: " + resIterativo[0]);
        System.out.println("Tiempo: " + resIterativo[1] + " ms\n");

        Object[] resRecursivo = factorialRecursivo(numero);
        System.out.println("Recursivo (N = " + numero + ")");
        System.out.println("Resultado: " + resRecursivo[0]);
        System.out.println("Tiempo acumulado: " + resRecursivo[1] + " ms");

    }
    public static Object[] factorial(int n){
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        long inicio = System.nanoTime();
        BigInteger resultado = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1_000_000.0;
        return new Object[]{resultado, tiempoMs};
    }

    public static Object[] factorialRecursivo(int n){
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }

        long inicio = System.nanoTime();

        BigInteger resultado;
        if (n == 0 || n == 1) {
            resultado = BigInteger.ONE;
        } else {
            Object[] subRes = factorialRecursivo(n - 1);
            BigInteger subFactorial = (BigInteger) subRes[0];
            resultado = BigInteger.valueOf(n).multiply(subFactorial);
        }

        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1_000_000.0;

        return new Object[]{resultado, tiempoMs};
    }
}
