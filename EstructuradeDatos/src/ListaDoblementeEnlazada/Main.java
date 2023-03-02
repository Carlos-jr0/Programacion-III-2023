package ListaDoblementeEnlazada;

import ListaEnlazadaSimple.ListaEnlazada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListaEnlazadaDoble lista=new ListaEnlazadaDoble();
		//Agregango al inicio 10
		lista.AgregarAlInicio(10);
		//Agregango al inicio 20-->10
		lista.AgregarAlInicio(20);
		//Agregango al inicio 30-->20-->10
		lista.AgregarAlInicio(30);
		
		lista.imprimirListaDoble();


	}

}
