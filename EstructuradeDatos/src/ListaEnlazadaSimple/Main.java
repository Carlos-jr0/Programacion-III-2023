package ListaEnlazadaSimple;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListaEnlazada lista=new ListaEnlazada();
		//Agregango al inicio 10
		lista.agregarAlInicio(10);
		//Agregango al inicio 20-->10
		lista.agregarAlInicio(20);
		//Agregango al inicio 30-->20-->10
		lista.agregarAlInicio(30);
		//Agregando al final 30-->20-->10-->40
		lista.agregarAlFinal(40);
		//Agregando al final 30-->20-->10-->40-->50
		lista.agregarAlFinal(50);
		//imprimir lista
		lista.imprimirLista();

	}

}
