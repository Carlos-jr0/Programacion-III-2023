package ListaDoblementeEnlazada;

import ListaEnlazadaSimple.Nodo;

public class NodoDoble {
	private int dato;
	private NodoDoble siguiente;
	private NodoDoble anterior;
	
	public NodoDoble(int dato) {
		this(dato, null, null);
	}
	
	public NodoDoble(int dato, NodoDoble s, NodoDoble a) {
		this.dato=dato;
		this.siguiente=s;
		this.anterior=a;
	}
	
	public int getDato() {
		return dato;
	}
	
	public void setDato(int dato) {
		this.dato=dato;
	}
	
	public NodoDoble getSiguiente() {
		return siguiente;
	}
	
	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente=siguiente;
	}
	
	public NodoDoble getAnterior() {
		return anterior;
	}
	
	public void setAnterior(NodoDoble anterior) {
		this.anterior=anterior;
	}



}
