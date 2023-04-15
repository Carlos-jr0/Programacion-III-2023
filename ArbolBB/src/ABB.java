
public class ABB {
	
	Nodo raiz; 
	
	public ABB(){
		raiz=null;
	}
	
	//Metodo para insertar un valor
	public void insertar(int val) {
		raiz=insertarValor(raiz, val);
	}
	
	//Metodo para insertar un valor en el arbol
	public Nodo insertarValor(Nodo raiz, int val) {
		if(raiz==null) {
			raiz=new Nodo(val);
			return raiz;
		}
		
		if(val<raiz.val ) {
			raiz.izq=insertarValor(raiz.izq, val);
		}else if(val>raiz.val) {
			raiz.der=insertarValor(raiz.der, val);
		}
		
		return raiz;
	}
	
	//Metodo para buscar un valor
	public boolean buscar(int val) {
		return buscarValor(raiz, val);
	}
	
	//Metodo para buscar un valor en el arbol
	public boolean buscarValor(Nodo raiz, int val) {
		if(raiz==null) {
			return false;
		}
		
		if(raiz.val==val) {
			return true;
		}
		
		if(val<raiz.val) {
			return buscarValor(raiz.izq, val);
		}else {
			return buscarValor(raiz.der, val);
		}
	}
	
	//Metodo para borrar un valor
	public void borrar(int val) {
		raiz=borrarValor(raiz, val);
	}
	
	//Metodo para borrar un valor del arbol
	public Nodo borrarValor(Nodo raiz, int val) {
		if(raiz==null) {
			return raiz;
		}
		
		if(val<raiz.val) {
			raiz.izq=borrarValor(raiz.izq, val);
		}else if(val>raiz.val) {
			raiz.der=borrarValor(raiz.der, val);
		}else {
			if(raiz.izq==null) {
				return raiz.der;
			}else if(raiz.der==null) {
				return raiz.izq;
			}
			
			raiz.val=valorMinimo(raiz.der);
			raiz.der=borrarValor(raiz.der, raiz.val);
		}
		return raiz;
	}
	
	public int valorMinimo(Nodo raiz) {
		int valorMinimo=raiz.val;
		while(raiz.izq!=null) {
			valorMinimo=raiz.izq.val;
			raiz=raiz.izq;
		}
		return valorMinimo;
	}
	
	public void inorden() {
		inorden(raiz);
	}
	
	public void inorden(Nodo raiz) {
		if(raiz!=null) {
			inorden(raiz.izq);
			System.out.print(raiz.val + " ");
			inorden(raiz.der);
		}
	}
	
	public void postorden() {
		postorden(raiz);
	}
	
	public void postorden(Nodo raiz) {
		if(raiz!=null) {
			postorden(raiz.izq);
			postorden(raiz.der);
			System.out.print(raiz.val + " ");
		}
	}
	
	public void preorden() {
		preorden(raiz);
	}
	
	public void preorden(Nodo raiz) {
		if(raiz!=null) {
			System.out.print(raiz.val + " ");
			preorden(raiz.izq);
			preorden(raiz.der);
		}
	}

}
