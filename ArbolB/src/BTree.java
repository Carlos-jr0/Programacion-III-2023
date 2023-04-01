
import java.util.ArrayList;

	public class BTree {
	private int grado;
    private Node raiz;

    public BTree(int grado) {
        this.grado = grado;
        raiz = new Node(grado);
    }

    public void insertar(int clave) {
        Node r = raiz;
        if (r.numClaves == 2 * grado - 1) {
            Node s = new Node(grado);
            raiz = s;
            s.hijos[0] = r;
            s.split(0, r);
            s.insertarNoLleno(clave);
        } else {
            r.insertarNoLleno(clave);
        }
    }

    public void eliminar(int clave) {
        if (raiz.numClaves == 0) {
            return;
        }
        raiz.eliminar(clave);
        if (raiz.numClaves == 0) {
            raiz = raiz.hijos[0];
        }
    }

    public boolean buscar(int clave) {
        return raiz.buscar(clave);
    }

	    private class Node {
	        int numClaves;
	        int[] claves;
	        Node[] hijos;
	        boolean hoja;

        public Node(int grado) {
            numClaves = 0;
            claves = new int[2 * grado - 1];
            hijos = new Node[2 * grado];
            hoja = true;
        }

        public void split(int indice, Node nodo) {
            Node nuevo = new Node(grado);
            nuevo.hoja = nodo.hoja;
            nuevo.numClaves = grado - 1;

            for (int j = 0; j < grado - 1; j++) {
                nuevo.claves[j] = nodo.claves[j + grado];
            }
            if (!nodo.hoja) {
                for (int j = 0; j < grado; j++) {
                    nuevo.hijos[j] = nodo.hijos[j + grado];
                }
            }
            nodo.numClaves = grado - 1;

            for (int j = numClaves; j >= indice + 1; j--) {
                hijos[j + 1] = hijos[j];
            }
            hijos[indice + 1] = nuevo;

            for (int j = numClaves - 1; j >= indice; j--) {
                claves[j + 1] = claves[j];
            }
            claves[indice] = nodo.claves[grado - 1];

            numClaves++;
        }

        public void insertarNoLleno(int clave) {
            int i = numClaves - 1;

            if (hoja) {
                while (i >= 0 && claves[i] > clave) {
                    claves[i + 1] = claves[i];
                    i--;
                }
                claves[i + 1] = clave;
                numClaves++;
            } else {
                while (i >= 0 && claves[i] > clave) {
                    i--;
                }
                if (hijos[i + 1].numClaves == 2 * grado - 1) {
                    split(i + 1, hijos[i + 1]);
                    if (claves[i

                + 1] < clave) {
                    i++;
                }
            }
            hijos[i + 1].insertarNoLleno(clave);
        }
    }

	    public void eliminar(int clave) {
	        int indice = encontrarIndice(clave);
	
	        if (indice < numClaves && claves[indice] == clave) {
	            if (hoja) {
	                eliminarHoja(indice);
	            } else {
	                eliminarNoHoja(indice);
	            }
	        } else {
	            if (hoja) {
	                return;
	            }
	            boolean flag = ((indice == numClaves) ? true : false);
	
	            if (hijos[indice].numClaves < grado) {
	                llenar(indice);
	            }
	            if (flag && indice > numClaves) {
	                hijos[indice - 1].eliminar(clave);
	            } else {
	                hijos[indice].eliminar(clave);
	            }
	        }
	    }
	
	    public boolean buscar(int clave) {
	        int i = 0;
	        while (i < numClaves && clave > claves[i]) {
	            i++;
	        }
	        if (i < numClaves && claves[i] == clave) {
	            return true;
	        }
	        if (hoja) {
	            return false;
	        }
	        return hijos[i].buscar(clave);
	    }
	
	    private int encontrarIndice(int clave) {
	        int indice = 0;
	        while (indice < numClaves && claves[indice] < clave) {
	            indice++;
	        }
	        return indice;
	    }
	
	    private void eliminarHoja(int indice) {
	        for (int i = indice + 1; i < numClaves; i++) {
	            claves[i - 1] = claves[i];
	        }
	        numClaves--;
	    }
	
	    private void eliminarNoHoja(int indice) {
	        int clave = claves[indice];
	
	        if (hijos[indice].numClaves >= grado) {
	            int predecesor = obtenerPredecesor(indice);
	            claves[indice] = predecesor;
	            hijos[indice].eliminar(predecesor);
	        } else if (hijos[indice + 1].numClaves >= grado) {
	            int sucesor = obtenerSucesor(indice);
	            claves[indice] = sucesor;
	            hijos[indice + 1].eliminar(sucesor);
	        } else {
	            fusionar(indice);
	            hijos[indice].eliminar(clave);
	        }
	    }
	
	    private int obtenerPredecesor(int indice) {
	        Node nodo = hijos[indice];
	        while (!nodo.hoja) {
	            nodo = nodo.hijos[nodo.numClaves];
	        }
	        return nodo.claves[nodo.numClaves - 1];
	    }
	
	    private int obtenerSucesor(int indice) {
	        Node nodo = hijos[indice + 1];
	        while (!nodo.hoja) {
	            nodo = nodo.hijos[0];
	        }
	        return nodo.claves[0];
	    }
	
	    private void llenar(int indice) {
	        if (indice != 0 && hijos[indice - 1].numClaves >= grado) {
	            prestarDeAnterior(indice);
	        } else if (indice != numClaves && hijos[indice + 1].numClaves >= grado) {
	            prestarDeSiguiente(indice);
	        } else {
	            if (indice != numClaves) {
	                fusionar(indice);
	            } else {
	                fusionar(indice - 1);
	            }
	        }
	    }
	
	    private void prestarDeAnterior(int indice) {
	    	Node hijo = hijos[indice];
	    	Node hermano = hijos[indice - 1];
	
	        for (int i = hijo.numClaves - 1; i >= 0; i--) {
	            hijo.claves[i + 1] = hijo.claves[i];
	        }
	
	        if (!hijo.hoja) {
	            for (int i = hijo.numClaves; i >= 0; i--) {
	                hijo.hijos[i + 1] = hijo.hijos[i];
	            }
	        }
	
	        hijo.claves[0] = claves[indice - 1];
	
	        if (!hijo.hoja) {
	            hijo.hijos[0] = hermano.hijos[hermano.numClaves];
	        }
	
	        claves[indice - 1] = hermano.claves[hermano.numClaves - 1];
	
	        hijo.numClaves++;
	        hermano.numClaves--;
	    }
	
	    private void prestarDeSiguiente(int indice) {
	        Node hijo = hijos[indice];
	        Node hermano = hijos[indice + 1];
	
	        hijo.claves[hijo.numClaves] = claves[indice];
	
	        if (!hijo.hoja) {
	            hijo.hijos[hijo.numClaves + 1] = hermano.hijos[0];
	        }
	
	        claves[indice] = hermano.claves[0];
	
	        for (int i = 1; i < hermano.numClaves; i++) {
	            hermano.claves[i - 1] = hermano.claves[i];
	        }
	
	        if (!hermano.hoja) {
	            for (int i = 1; i <= hermano.numClaves; i++) {
	                hermano.hijos[i - 1] = hermano.hijos[i];
	            }
	        }
	
	        hijo.numClaves++;
	        hermano.numClaves--;
	    }
	
	    private void fusionar(int indice) {
	        Node hijo = hijos[indice];
	        Node hermano = hijos[indice + 1];
	
	        hijo.claves[grado - 1] = claves[indice];
	
	        for (int i = 0; i < hermano.numClaves; i++) {
	            hijo.claves[i + grado] = hermano.claves[i];
	        }
	
	        if (!hijo.hoja) {
	            for (int i = 0; i <= hermano.numClaves; i++) {
	                hijo.hijos[i + grado] = hermano.hijos[i];
	            }
	        }
	
	        for (int i = indice + 1; i < numClaves; i++) {
	            claves[i - 1] = claves[i];
	        }
	
	        for (int i = indice + 2; i <= numClaves; i++) {
	            hijos[i - 1] = hijos[i];
	        }
	
	        hijo.numClaves += hermano.numClaves + 1;
	        numClaves--;
	
	        hermano = null;
	    }
	
	    public void mostrar() {
	        for (int i = 0; i < numClaves; i++) {
	            System.out.print(claves[i] + " ");
	        }
	
	        if (!hoja) {
	            for (int i = 0; i <= numClaves; i++) {
	                hijos[i].mostrar();
	            }
	        }
	    }    
	   
	}

}
