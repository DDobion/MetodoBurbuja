/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodoburbuja;

import java.util.Arrays;
import java.util.Random;

public class ComparativaBurbuja {

    public static void main(String[] args) {
        int N = 20; 
        int[] arregloOriginal = generarArregloAleatorio(N);

        // Clonar el arreglo para que ambos métodos trabajen con los mismos datos
        int[] arregloBurbuja = arregloOriginal.clone();
        int[] arregloBurbujaMejorado = arregloOriginal.clone();

        System.out.println("Arreglo original: " + Arrays.toString(arregloOriginal));

        // Comparativa de Burbuja
        long inicioBurbuja = System.nanoTime();
        burbuja(arregloBurbuja);
        long finBurbuja = System.nanoTime();
        long tiempoBurbuja = finBurbuja - inicioBurbuja;

        System.out.println("Arreglo ordenado con Burbuja: " + Arrays.toString(arregloBurbuja));
        System.out.println("Tiempo Burbuja: " + tiempoBurbuja / 1_000_000.0 + " ms");

        // Comparativa de Burbuja Mejorado
        long inicioBurbujaMejorado = System.nanoTime();
        burbujaMejorado(arregloBurbujaMejorado);
        long finBurbujaMejorado = System.nanoTime();
        long tiempoBurbujaMejorado = finBurbujaMejorado - inicioBurbujaMejorado;

        System.out.println("Arreglo ordenado con Burbuja Mejorado: " + Arrays.toString(arregloBurbujaMejorado));
        System.out.println("Tiempo Burbuja Mejorado: " + tiempoBurbujaMejorado / 1_000_000.0 + " ms");
    }

    // Método Burbuja 
    public static void burbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    // Método Burbuja mejorado 
    public static void burbujaMejorado(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambio;
        for (int i = 0; i < n - 1; i++) {
            intercambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    intercambio = true;
                }
            }
            if (!intercambio) {
                break;
            }
        }
    }

    // Numeros aleatorios :D
    public static int[] generarArregloAleatorio(int N) {
        Random rand = new Random();
        int[] arreglo = new int[N];
        for (int i = 0; i < N; i++) {
            arreglo[i] = rand.nextInt(100); 
        }
        return arreglo;
    }
}

