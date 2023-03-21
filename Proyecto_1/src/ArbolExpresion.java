import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.JOptionPane;

public class ArbolExpresion {
	Nodo raiz;
	
		/*public ArbolExpresion() {
		this.raiz=null;
		}
	
		public ArbolExpresion(Nodo raiz) {
		this.raiz=raiz;
		}*/
	
	private boolean esOperador(char c) {
	    return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
	
	}
	
	public double evaluarExpresion(String expresion) {
		
		//dividir la expresion en componentes basicos utilizando una expresion regular
		String[] componentes = expresion.split("(?<=[-+*/√^()])|(?=[-+*/√^()])");
		
		//Crear pilas para los valores numericos y los operadores
		Stack<Double> valores = new Stack<>();
		Stack<Character> operadores = new Stack<>();
		
		//Recorrer la expresion y agregar los valores numericos y los operadores a la pila
		for(String componente : componentes) {
			if(componente.isEmpty()) {
				continue;
			}else if(componente.matches("[0-9]+(\\\\.[0-9]+)?")) {
				//Es un valor numerico
				valores.push(Double.parseDouble(componente));
			}else if(componente.matches("[-+*/√^]")) {
				//Es un operador
				char operador= componente.charAt(0);
				while(!operadores.isEmpty() && tienePrecedencia(operador, operadores.peek())) {
					evaluarOperador(valores, operadores.pop());
				}
				operadores.push(operador);
			}else if(componente.equals("(")) {
				//parentesis izq
				operadores.push('(');
			}else if(componente.equals(")")) {
				//parentesis der
				while(operadores.peek()!='(') {
					evaluarOperador(valores, operadores.pop());
				}
				operadores.pop();
			}
		}
		//evaluar operadores restantes
		while(!operadores.isEmpty()) {
			evaluarOperador(valores, operadores.pop());
		}
		return valores.pop();
		
	}
	
	//Metodo para evaluar la presedencia de cada operador
	public boolean tienePrecedencia(char operador1, char operador2) {
		if(operador2 =='(' || operador2 == ')') {
			return false;
		}else if((operador1 == '√' || operador1 == '^') && operador2 != '√' && operador2 != '^') {
			return false;
		}else if((operador1 == '*' || operador1 == '/') && operador2 == '+' && operador2 == '-') {
			return false;
		}else {
			return true;
		}
	}
	
	//Metodo para evaluar el tipo de operador
	public void evaluarOperador(Stack<Double> valores, char operador) {
		double valor2=valores.pop();
		double valor1=valores.pop();
		
		switch(operador) {
		case '+':
			valores.push(valor1 + valor2);
			break;
		case '-':
			valores.push(valor1 - valor2);
			break;	
		case '*':
			valores.push(valor1 * valor2);
			break;
		case '/':
			valores.push(valor1 / valor2);
			break;
		case '√':
			valores.push(Math.sqrt(valor2));
			break;
		case '^':
			valores.push(Math.pow(valor2, valor1));
			break;
		default:
			break;
		}
	}

}
