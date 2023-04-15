
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ABB abb=new ABB();
		abb.insertar(10);
		abb.insertar(8);
		abb.insertar(20);
		abb.insertar(6);
		abb.insertar(15);
		
		System.out.print("Recorrido Inorden: ");
		abb.inorden();
		System.out.println();
		
		System.out.print("Recorrido Postorden: ");
		abb.postorden();
		System.out.println();
		
		System.out.print("Recorrido Preorden: ");
		abb.preorden();
		System.out.println();
		System.out.println();
		
		int buscar=10;
		if(abb.buscar(buscar)) {
			System.out.println(buscar + " se encuentra en el arbol");
		}else {
			System.out.println(buscar + " no se encuentra en el arbol");
		}
		
		System.out.println();
		int borrar=6;
		abb.borrar(borrar);
		if(abb.buscar(borrar)) {
			System.out.println(borrar + " todavia se encuentra en el arbol");
		}else {
			System.out.println(borrar + " se elimino correctamente del arbol");
		}
		
		System.out.println();
		System.out.print("Recorrido Inorden: ");
		abb.inorden();
		System.out.println();
		
		System.out.print("Recorrido Postorden: ");
		abb.postorden();
		System.out.println();
		
		System.out.print("Recorrido Preorden: ");
		abb.preorden();
		System.out.println();

	}

}
