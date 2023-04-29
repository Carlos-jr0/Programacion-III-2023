
public class Vehiculo {
	
	//Definimos las propiedades del vehiculo
	String placa;
	String color;
	String linea;
	String modelo;
	String propietario;
	Vehiculo siguiente;
	
	//Constructor con las propiedades de vehiculo
	public Vehiculo(String placa, String color, String linea, String modelo, String propietario) {
		this.placa=placa;
		this.color=color;
		this.linea=linea;
		this.modelo=modelo;
		this.propietario=propietario;
		this.siguiente=null;
		
	}

}
