import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matriz matriz=new Matriz(10, 10);
	
		int opcion=0;
		do {
		opcion=Integer.parseInt(
				JOptionPane.showInputDialog("== Por favor ingrese una opcion == \n" +
											"1. Insertar vehiculo\n" + 
											"2. Buscar vehiculo\n" + 
											"3. Eliminar vehiculo\n" + 
											"4. Mostrar todos los vehiculos\n" + 
											"5. Salir\n\n"));
		switch(opcion){
		case 1: 
			String placa=JOptionPane.showInputDialog("Ingrese la placa del vehiculo: ");
			String color=JOptionPane.showInputDialog("Ingrese el color del vehiculo: ");
			String linea=JOptionPane.showInputDialog("Ingrese la linea del vehiculo: ");
			String modelo=JOptionPane.showInputDialog("Ingrese el modelo del vehiculo: ");
			String propietario=JOptionPane.showInputDialog("Ingrese el nombre del propietario del vehiculo: ");
			int fila=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila donde quiere insertar el vehiculo"));
			int columna=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna donde quiere insertar el vehiculo"));
			matriz.insertar(placa,color,linea,modelo,propietario, fila, columna);
			break;
		case 2:
			String busca=JOptionPane.showInputDialog("Ingrese la propiedad del vehiculo a buscar");
			Vehiculo vehiculo1=matriz.buscar(busca);
			if(vehiculo1!=null) {
				JOptionPane.showMessageDialog(null, "Se encontro el vehiculo: \n" + "Placa: " + vehiculo1.placa + " -Color: " + vehiculo1.color + " -Linea: " + vehiculo1.linea + " -Modelo: " + vehiculo1.modelo + " -Propietario: " + vehiculo1.propietario);
			}else {
				JOptionPane.showMessageDialog(null, "No se encontro ningun vehiculo con esta propiedad: " + busca);
			}
			break;
		case 3: 
			String elimina=JOptionPane.showInputDialog("Ingrese la propiedad del vehiculo a eliminar");
			matriz.eliminar(elimina);
				JOptionPane.showMessageDialog(null, "EL vehiculo con propiedad " + elimina + " ha sido eliminado");
			break;
		case 4: 
			matriz.listar();
			break;
			
		case 5:
			JOptionPane.showMessageDialog(null, "Has salido con exito!");
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Opcion invalida.");
			break;
		}
	}while(opcion !=5);
  }
}
