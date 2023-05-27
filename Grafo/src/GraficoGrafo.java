
import java.awt.*;
import javax.swing.*;

public class GraficoGrafo extends JFrame {
    private int numNodos;
    private int[][] matrizAdyacencia;

    public GraficoGrafo(int numNodos, int[][] matrizAdyacencia) {
        this.numNodos = numNodos;
        this.matrizAdyacencia = matrizAdyacencia;

        setTitle("Grafo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int radio = 150;
                int centroX = getWidth() / 2;
                int centroY = getHeight() / 2;

                // Dibujar nodos
                for (int i = 0; i < numNodos; i++) {
                    int angulo = 360 * i / numNodos;
                    int x = (int) (centroX + radio * Math.cos(Math.toRadians(angulo)));
                    int y = (int) (centroY + radio * Math.sin(Math.toRadians(angulo)));

                    g.setColor(Color.BLUE);
                    g.fillOval(x - 15, y - 15, 30, 30);

                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(i +1), x - 5, y + 5);
                }
                // Dibujar arcos
                for (int i = 0; i < numNodos; i++) {
                    for (int j = i + 1; j < numNodos; j++) {
                        if (matrizAdyacencia[i][j] != 0) {
                            int x1 = (int) (centroX + radio * Math.cos(Math.toRadians(360 * i / numNodos)));
                            int y1 = (int) (centroY + radio * Math.sin(Math.toRadians(360 * i / numNodos)));

                            int x2 = (int) (centroX + radio * Math.cos(Math.toRadians(360 * j / numNodos)));
                            int y2 = (int) (centroY + radio * Math.sin(Math.toRadians(360 * j / numNodos)));

                            g.setColor(Color.BLUE);
                            g.drawLine(x1, y1, x2, y2);

                            int etiquetaX = (x1 + x2) / 2;
                            int etiquetaY = (y1 + y2) / 2;

                            g.setColor(Color.BLACK);
                            g.drawString(String.valueOf(matrizAdyacencia[i][j]), etiquetaX - 5, etiquetaY + 5);
                        }
                    }
                }
            }
        };

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        // Crear la matriz de adyacencia (ejemplo con 5 nodos)
    	//Copiamos  los datos que nos da la MatrizAdyancenciaGrafo, los pesos para cada nodo
        int[][] matrizAdyacencia = {
                {0, 0, 1, 2},
                {3, 0, 0, 1},
                {2, 3, 0, 0},
                {4, 0, 5, 0}
                
               
        };

        // Crear y mostrar el gráfico del grafo
        //Ingresamos el numero de nodos que queremos graficar
        GraficoGrafo grafico = new GraficoGrafo(4, matrizAdyacencia);
        grafico.setVisible(true);
    }
}
