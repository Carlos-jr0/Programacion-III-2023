
public class Principal {

		    	public static void main(String[] args) {
		    		// TODO Auto-generated method stub
		    		    BTree btree = new BTree(3); // Crear un árbol B de grado 3
		    	        
		    	        // Insertar algunas claves en el árbol
		    	        btree.insertar(10);
		    	        btree.insertar(20);
		    	        btree.insertar(5);
		    	        btree.insertar(6);
		    	        btree.insertar(12);
		    	        btree.insertar(30);
		    	        btree.insertar(7);
		    	        
		    	        // Mostrar el árbol después de insertar las claves
		    	        System.out.println("Árbol B después de insertar algunas claves:");
		    	        btree.mostrar();
		    	        System.out.println("");
		    	        
		    	        // Buscar algunas claves en el árbol
		    	        System.out.println("Búsqueda de claves en el árbol:");
		    	        System.out.println("10: " + btree.buscar(10));
		    	        System.out.println("50: " + btree.buscar(50));
		    	        System.out.println();
		    	        
		    	        // Eliminar algunas claves del árbol
		    	        btree.eliminar(6);
		    	        btree.eliminar(30);
		    	        
		    	        // Mostrar el árbol después de eliminar algunas claves
		    	        System.out.println("Árbol B después de eliminar algunas claves:");
		    	        btree.mostrar();
		    	}
		    

	}


