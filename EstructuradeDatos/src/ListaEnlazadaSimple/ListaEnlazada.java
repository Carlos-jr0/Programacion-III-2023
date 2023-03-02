package ListaEnlazadaSimple;

public class ListaEnlazada {
	private Nodo primero;
	private Nodo ultimo;
	private Nodo actual;
	private int cantidad;
	
	public ListaEnlazada() {
		cantidad=0;
		primero=null;
		ultimo=null;
		actual=null;
	}
	
	public void agregarAlInicio(int info) {
		//Crear un nodo e inicializar el campo dato al nuevo elemento (info)
		//Se asigna un nuevo nodo
		Nodo nuevoNodo = new Nodo (info);
		
		//El campo siguiente del nuevo nodo apunte a primero de la lista
		nuevoNodo.setSiguiente(primero);
		
		//Primero apunte a nuevo nodo
		primero=nuevoNodo;
		
		//Asigna el valor del ultimo nodo unicamente cuando la lista esta vacia
		if(cantidad==0) {
			ultimo=nuevoNodo;
		}
		cantidad++;
	}
	
	public void agregarAlFinal(int info) {
		//Crear un nodo e inicializar el campo dato al nuevo elemento (info)
		//La referencia del nodo creado se asigna a nuevo
		Nodo nuevoNodo = new Nodo (info);
		
		//El puntero siguiente del ultimo nodo debe apuntar al nuevoNodo
		ultimo.setSiguiente(nuevoNodo);
		
		//actualizar el valor de ultimo para que apunte al nodo Nuevo
		ultimo=nuevoNodo;
		
		//Asigna el  valor del primero unicamente cuando la lista este vacia
		if(cantidad==0) {
			primero=nuevoNodo;
		}
		cantidad++;
	}
	
	public void imprimirLista() {
		//ubicar el primer elemento
		actual=primero;
		
		while(actual!=null) {
			//leer el dato y mostrarlo en pantalla
			System.out.print(actual.getDato() + "-->");
			
			//Identificar siguiente nodo
			actual=actual.getSiguiente();
		}
		
		System.out.println("Null");
	}
}
