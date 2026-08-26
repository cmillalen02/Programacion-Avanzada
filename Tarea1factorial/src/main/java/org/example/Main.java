package org.example;
public class Main {
    public static void main(String[] args) {
        int numero=5;
        factorial(numero);
        double[] res= factorialRecursivo(numero);
        System.out.println("Resultado: " + (long) res[0]);
        System.out.println("Tiempo: " + res[1] + "ms");

    }
    public static double[] factorial(int n){
        if(n < 0){
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        long inicio = System.nanoTime();
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        long fin=System.nanoTime();
        double tiempoms=(fin-inicio)/1000000.0;
        System.out.println("Resultado: " +resultado + "," +  " Tiempo en milisegundos: " +tiempoms);
        return new double[]{(double)resultado,tiempoms};
    }

    public static double[] factorialRecursivo(int n){
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        long inicio = System.nanoTime();
        long resultado;
        if (n == 0 || n == 1) {
            resultado = 1;
        } else {
            double[] subRes = factorialRecursivo(n - 1);
            resultado = n * (long) subRes[0];
        }

        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1000000.0;

        return new double[]{(double) resultado, tiempoMs};
    }
}
