import java.util.Scanner;

public class MatrizAdyacenciaGrafo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de nodos del grafo: ");
        int numNodos = scanner.nextInt();

        int[][] matrizAdyacencia = new int[numNodos][numNodos];

        // Solicitar al usuario los pesos o longitudes de los caminos
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                if (i != j) {
                    System.out.print("Ingrese el peso o longitud del camino entre el nodo " + (i + 1) + " y el nodo " + (j + 1) + ": ");
                    matrizAdyacencia[i][j] = scanner.nextInt();
                } else {
                    // Si el nodo es el mismo, establecer el peso como 0
                    matrizAdyacencia[i][j] = 0;
                }
            }
        }

        // Imprimir la matriz de adyacencia
        System.out.println("\nMatriz de adyacencia del grafo:");
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
}