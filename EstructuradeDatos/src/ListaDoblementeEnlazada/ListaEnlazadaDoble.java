package ListaDoblementeEnlazada;

public class ListaEnlazadaDoble {
	
	private NodoDoble primero;
	private NodoDoble ultimo;
	private NodoDoble actual;
	
	public ListaEnlazadaDoble() {
		primero=null;
		ultimo=null;
		actual=null;
	}
	
	public boolean estaVacia() {
		return primero==null;
	}
	
	public void AgregarAlInicio(int info) {
		if(!estaVacia()) {
			primero=new NodoDoble(info, null, ultimo);
			primero.setSiguiente(primero);
		}else {
			primero=ultimo=new NodoDoble(info);
		}
	
	}
	
	public void AgregarAlFinal(int info) {
		if(!estaVacia()) {
			ultimo=new NodoDoble(info, primero, null);
			ultimo.setSiguiente(ultimo);
		}else {
			primero=ultimo=new NodoDoble(info);
		}
		
		
  }
	
	public void imprimirListaDoble() {
		if(!estaVacia()) {
			actual=primero;
			
			while(actual!=null) {
				System.out.print(actual.getDato() + "-->");
				
				actual=actual.getSiguiente();
			}
			
			System.out.println("Null");
		}

  }
}