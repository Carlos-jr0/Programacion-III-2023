
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVL avl=new AVL();
		avl.insertar(50);
		avl.insertar(10);
		avl.insertar(20);
		avl.insertar(15);
		avl.insertar(60);
		avl.insertar(5);
		
		System.out.print("Recorrido Inorden: ");
		avl.inorden();
		System.out.println();
		
		System.out.print("Recorrido Postorden: ");
		avl.postorden();
		System.out.println();
		
		System.out.print("Recorrido Preorden: ");
		avl.preorden();
		System.out.println();
		System.out.println();
		
		int buscar=80;
		if(avl.buscar(buscar)) {
			System.out.println(buscar + " se encuentra en el arbol");
		}else {
			System.out.println(buscar + " no se encuentra en el arbol");
		}
		
		System.out.println();
		int borrar=20;
		avl.borrar(borrar);
		if(avl.buscar(borrar)) {
			System.out.println(borrar + " todavia se encuentra en el arbol");
		}else {
			System.out.println(borrar + " se elimino correctamente del arbol");
		}
		
		System.out.println();
		System.out.print("Recorrido Inorden: ");
		avl.inorden();
		System.out.println();
		
		System.out.print("Recorrido Postorden: ");
		avl.postorden();
		System.out.println();
		
		System.out.print("Recorrido Preorden: ");
		avl.preorden();
		System.out.println();
		
	}

}
