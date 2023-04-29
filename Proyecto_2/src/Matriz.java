
public class Matriz {
	Vehiculo[][] matriz;
	int filas;
	int columnas;
	
	//Constructor
	public Matriz(int filas, int columnas) {
		this.filas=filas;
		this.columnas=columnas;
		matriz=new Vehiculo[filas][columnas];
	}
	
	//Metodo para insertar un vehiculo en la matriz, con lista enlazada
	public void insertar(String placa, String color, String linea, String modelo, String propietario, int fila, int columna) {
		Vehiculo nuevoVehiculo=new Vehiculo(placa, color,  linea, modelo, propietario);
		//Se verifica si la posicion (fila y columna) estan dentro de los limites de la matriz
		if(fila >=0 && fila<filas && columna>=0 && columna<columnas) {
			/*Se verifica si la casilla de la matriz en la posicion (fila y columna) estan vacias
			si esta vacia se inserta el nuevo vehiculo en la posicion.*/
			if(matriz[fila][columna]==null) {
				matriz[fila][columna]=nuevoVehiculo;
			}else {
				/*Si ya existe un nodo en la posicion se enlaza con el nuevo vehiculo
				Primero se crea una referencia actual, luego se corre la lista enlazada a traves de un ciclo hasta que 
				llegue al ultimo nodo de la lista.*/
				Vehiculo actual=matriz[fila][columna];
				while(actual.siguiente!=null) {
					actual=actual.siguiente;
				}
				actual.siguiente=nuevoVehiculo;
			}
		}else {
			//Si la posicion (fila y columna) estan fuera de los limites muestra mensaje
			System.out.println("Error: posicion invalida en la matriz");
		}
		
	}
	
	//Metodo para buscar un vehiculo en la matriz por cualquier propiedad
	public Vehiculo buscar(String valor) {
		//Recorrer todas las posiciones de la matriz
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[0].length; j++) {
				//Se obtiene una referencia al vehiculo en la posicion actual (i, j) de la matirz
				Vehiculo vehiculo=matriz[i][j];
				//Si el nodo no es nullo y si alguna de las propiedades coincide con el valor buscado devuelve el nodo
				if(vehiculo!=null && (vehiculo.placa.equalsIgnoreCase(valor)||
										vehiculo.color.equalsIgnoreCase(valor)||
										vehiculo.linea.equalsIgnoreCase(valor)||
										vehiculo.modelo.equalsIgnoreCase(valor)||
										vehiculo.propietario.equalsIgnoreCase(valor))) {
										return vehiculo;
					
				}
			}
		}
		//Si no se encuentra el vehiculo, retornara null
		return null; 
	}
	
	//Metodo para eliminar un vehiculo de la matriz
	public void eliminar(String valor) {
		//Recorre todas las posicones de la matriz con lista enlazada 
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[0].length; j++) {
				//Se obtiene una referencia al vehiculo en la posicion actual (i, j) de la matirz
				Vehiculo vehiculo=matriz[i][j];
				//verifica si el valor coincide con alguna propiedad
				if(vehiculo!=null && (vehiculo.placa.equalsIgnoreCase(valor)||
										vehiculo.color.equalsIgnoreCase(valor)||
										vehiculo.linea.equalsIgnoreCase(valor)||
										vehiculo.modelo.equalsIgnoreCase(valor)||
										vehiculo.propietario.equalsIgnoreCase(valor))) {
									//Si coinciden el valor con la propiedad y los vuelve null (elimina)
										matriz[i][j]=null;
										return;
					
				}
			}
		}
	}
	
	//Metodo para listar todo el contenido que contiene la matriz
	public void listar() {
		//Recorre toda la matriz con lista enlazada
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[0].length; j++) {
				//Se obtiene una referencia al vehiculo en la posicion actual (i, j) de la matirz
				Vehiculo actual=matriz[i][j];
				//Verifica si no es nulo e imprime los datos que son encontrados en cada nodo
				while(actual!=null) {
					System.out.println(" ");
					System.out.println("Placa: " + actual.placa + " -Color: " + actual.color + " -Linea: " + actual.linea + " -Modelo: " + actual.modelo + " -Propietario: " + actual.propietario);
					/*System.out.println("Color: " + actual.color);
					System.out.println("Linea: " + actual.linea);
					System.out.println("Modelo: " + actual.modelo);
					System.out.println("Propietario: " + actual.propietario);*/
					actual=actual.siguiente;
					System.out.println("-------------------------------------------------------------------------------------------- ");
				}
			}
		}
	}
}
