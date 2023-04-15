
public class AVL {
	Node raiz;
	
	public AVL() {
		raiz=null;
	}
	
	//Metodo para obtener la altura de un nodo
	public int obtenerAltura(Node node) {
		if(node==null) {
			return 0;
		}
		return node.altura;
	}
	
	//Metodo para obtener el maximo de dos numeros
	public int maximo(int a, int b) {
		return Math.max(a,b);
	}
	
	//Metodo para obtener el factor equilibrio
	public int obtenerFactorEquilibrio(Node node) {
		if(node==null) {
			return 0;
		}
		return obtenerAltura(node.izq)-obtenerAltura(node.der);
	}
	
	//Metodo para rotar a la derecha
	public Node rotarDerecha(Node node) {
		Node nuevoPadre=node.izq;
		Node hijoDerecho=nuevoPadre.der;
		
		//Realizar rotacion
		nuevoPadre.der=node;
		node.izq=hijoDerecho;
		
		//Actualizar alturas
		node.altura=maximo(obtenerAltura(node.izq), obtenerAltura(node.der))+1;
		nuevoPadre.altura=maximo(obtenerAltura(nuevoPadre.izq), obtenerAltura(nuevoPadre.der))+1;
		return nuevoPadre;
	}
	
	//Metodo para rotar a la izquierda
	public Node rotarIzquierda(Node node) {
		Node nuevoPadre=node.der;
		Node hijoIzquierdo=nuevoPadre.izq;
		
		//Realizar rotacion
		nuevoPadre.izq=node;
		node.der=hijoIzquierdo;
		
		//Actualizar alturas
		node.altura=maximo(obtenerAltura(node.izq), obtenerAltura(node.der))+1;
		nuevoPadre.altura=maximo(obtenerAltura(nuevoPadre.izq), obtenerAltura(nuevoPadre.der))+1;
		return nuevoPadre;
	}
	
	//Metodo para Insertar un valor en el arbol
	public Node insertar(Node node, int valor) {
		if(node==null) {
			return new Node(valor);
		}
		if(valor<node.valor ) {
			node.izq=insertar(node.izq, valor);
		}else if(valor>node.valor) {
			node.der=insertar(node.der, valor);
		}else {
			return node;
		}
		
		//Acturalizar la altura del nodo
		node.altura=1+maximo(obtenerAltura(node.izq), obtenerAltura(node.der));
		
		//Obtener el factor equilibrio del nodo
		int factorEquilibrio=obtenerFactorEquilibrio(node);
		
		//Realizar las rotaciones para balancear el arbol
		if(factorEquilibrio>1) {
			//Rotacion a la derecha
			if(valor<node.izq.valor) {
				return rotarDerecha(node);
			}else {
				//Rotacion doble a la izquierda-derecha
				node.izq=rotarIzquierda(node.izq);
				return rotarDerecha(node);
			}
		}else if(factorEquilibrio<-1) {
			//Rotacion a la izquierda
			if(valor>node.der.valor) {
				return rotarIzquierda(node);
			}else {
				//Rotacion doble a la derecha-izquierda
				node.der=rotarDerecha(node.der);
				return rotarIzquierda(node);
			}
		}
		//El arbol esta balanceado no es necesario hacer rotaciones
		return node;
	}
	
	//Metodo para insertar un valor en el arbol
	public void insertar(int valor) {
		raiz=insertar(raiz, valor);
	}
	
	//Metodo para imprimir el arbol en orden
	public void inorden() {
		inorden(raiz);
	}
	
	public void inorden(Node node) {
		if(node!=null) {
			inorden(node.izq);
			System.out.print(node.valor + " ");
			inorden(node.der);
		}
	}
	
	public void postorden() {
		postorden(raiz);
	}
	
	public void postorden(Node node) {
		if(node!=null) {
			postorden(node.izq);
			postorden(node.der);
			System.out.print(node.valor + " ");
		}
	}
	
	public void preorden() {
		preorden(raiz);
	}
	
	public void preorden(Node node) {
		if(node!=null) {
			System.out.print(node.valor + " ");
			preorden(node.izq);
			preorden(node.der);
		}
	}
	
	//Metodo para buscar un valor en el arbol
	public boolean buscar(int valor) {
		return buscarValor(raiz, valor);
	}
	
	public boolean buscarValor(Node node, int valor) {
		if(node==null) {
			return false;
		}
		
		if(node.valor==valor) {
			return true;
		}
		
		if(valor<node.valor) {
			return buscarValor(node.izq, valor);
		}else {
			return buscarValor(node.der, valor);
		}
	}
	
	public void borrar(int valor) {
		raiz=borrarValor(raiz, valor);
	}
	
	//Metodo para borrar un valor del arbol
		public Node borrarValor(Node node, int valor) {
			if(node==null) {
				return node;
			}
			
			if(valor<node.valor) {
				node.izq=borrarValor(node.izq, valor);
			}else if(valor>node.valor) {
				node.der=borrarValor(node.der, valor);
			}else {
				//Nodo encontrado realizar eliminacion
				//Caso 1: Nodo con un solo hijo o sin hijos
				if(node.izq==null||node.der==null) {
					Node hijo;
					if(node.izq!=null) {
						hijo=node.izq;
					}else {
						hijo=node.der;
					}
					//Caso 1.1: Nodo sin hijos
					if(hijo==null) {
						hijo=node;
						node=null;
					}else {
						//Caso 1.2: Nodo con un solo hijo
						node=hijo;
					}
						
				}else {
					//Caso 2: Nodo con dos hijos
					Node sucesor=encontrarMinimo(node.der);
					//Copiar el valor sucesor al nodo actual
					node.valor=sucesor.valor;
					//Eliminar el sucesor recursivamente
					node.der=borrarValor(node.der, sucesor.valor);
				}
			}
			
			//Si el arbol quedo vacio despues de la eliminacion
			if(node==null) {
				return node;
			}
			
			//Acturalizar la altura del nodo
			node.altura=1+maximo(obtenerAltura(node.izq), obtenerAltura(node.der));
			
			//Obtener el factor equilibrio del nodo
			int factorEquilibrio=obtenerFactorEquilibrio(node);
			
			//Realizar las rotaciones para balancear el arbol
			if(factorEquilibrio>1) {
				//Rotacion a la derecha
				if(valor<node.izq.valor) {
					return rotarDerecha(node);
				}else {
					//Rotacion doble a la izquierda-derecha
					node.izq=rotarIzquierda(node.izq);
					return rotarDerecha(node);
				}
			}else if(factorEquilibrio<-1) {
				//Rotacion a la izquierda
				if(valor>node.der.valor) {
					return rotarIzquierda(node);
				}else {
					//Rotacion doble a la derecha-izquierda
					node.der=rotarDerecha(node.der);
					return rotarIzquierda(node);
				}
		}
	return node;
	}
		
		Node encontrarMinimo(Node node) {
			Node actual=node;
			while(actual.izq!=null) {
				actual=actual.izq;
			}
			return actual;
		}

}
