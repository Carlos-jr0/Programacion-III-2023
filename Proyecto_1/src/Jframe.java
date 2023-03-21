import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Jframe extends JFrame {

	private JPanel contentPane;
	private JTextField txtExpresion;
	private JTextField txtImprimirInorden;
	private JTextField txtImprimirPostorden;
	private JTextField txtImprimirPreorden;
	private JTextField ImprimirNotacionPolaca;

	    // Función para verificar si un token dado es un operador
	    public static boolean isOperator(char c) {
	        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
	    
	    }
	    // Imprime la expresión en PostOrden
	    public static void postorder(Nodo root) {
	        if (root == null) {
	            return;
	        }
	        postorder(root.left);
	        postorder(root.right);
	        System.out.print(root.data);
	    }
	    //Imprime la expresion en Preorden
	    public void preOrden(Nodo root) {
			if(root==null) {
				return;
			}
			System.out.print(root.data + " ");
			preOrden(root.left);
			preOrden(root.right);
		}
	 
	    // Imprime la expresión en Orden
	    public static void inorder(Nodo root) {
	        if (root == null) {
	            return;
	        }
	 
	        // si el token actual es un operador, imprime un paréntesis abierto
	        if (isOperator(root.data)) {
	            System.out.print("(");
	        }
	 
	        inorder(root.left);
	        System.out.print(root.data);
	        inorder(root.right);
	 
	        // si el token actual es un operador, imprime cerrar paréntesis
	        if (isOperator(root.data)) {
	            System.out.print(")");
	        }
	    }
	 
	    // Función para construir un árbol de expresión a partir de la expresión sufijo dada
	    public static Nodo construct(String postfix) {
	        // caso base
	        if (postfix == null || postfix.length() == 0) {
	            return null;
	        }
	 
	        // crea una stack vacía para almacenar punteros de árbol
	        Stack<Nodo> s = new Stack<>();
	 
	        // recorrer la expresión de sufijo
	        for (char c: postfix.toCharArray()){
	            // si el token actual es un operador
	            if (isOperator(c)) {
	                // extrae dos nodos `x` e `y` de la stack
	                Nodo x = s.pop();
	                Nodo y = s.pop();
	 
	                // construye un nuevo árbol binario cuya raíz es el operador y cuyo
	                // los niños izquierdo y derecho apuntan a `y` y `x`, respectivamente
	                Nodo nodo = new Nodo(c, y, x);
	 
	                // inserta el nodo actual en la stack
	                s.add(nodo);
	            }
	            // si el token actual es un operando, crea un nuevo nodo de árbol binario
	            // cuya raíz es el operando y lo empuja a la stack
	            else {
	                s.add(new Nodo(c));
	            }
	        }
	 
	        // un puntero a la raíz del árbol de expresión permanece en la stack
	        return s.peek();
	    }
	 
	    
	public Jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar Expresión:");
		lblNewLabel.setBounds(10, 24, 118, 21);
		contentPane.add(lblNewLabel);
		
		txtExpresion = new JTextField();
		txtExpresion.setBounds(128, 24, 150, 21);
		contentPane.add(txtExpresion);
		txtExpresion.setColumns(10);
		
		JButton btnBoton = new JButton("Generar Arbol");
		btnBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnBoton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBoton.setForeground(new Color(0, 0, 0));
		btnBoton.setBounds(315, 23, 129, 23);
		contentPane.add(btnBoton);
		
		JButton btnPreorden = new JButton("Preorden");
		btnPreorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String expresion=txtExpresion.getText();
				Nodo root = construct(expresion);
				preOrden(root);
				
				
				//double resultado=evaluarExpresion(expresion);
				//txtImprimir.seText(resultado);
			}
		});
		btnPreorden.setBounds(10, 120, 96, 23);
		contentPane.add(btnPreorden);
		
		JButton btnPostorden = new JButton("Postorden");
		btnPostorden.setBounds(10, 88, 96, 23);
		contentPane.add(btnPostorden);
		
		txtImprimirInorden = new JTextField();
		txtImprimirInorden.setBounds(128, 57, 150, 21);
		contentPane.add(txtImprimirInorden);
		txtImprimirInorden.setColumns(10);
		
		JButton btnInorden = new JButton("Inorden");
		btnInorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expresion=txtExpresion.getText();
				if(expresion.contains("a")) {
					int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de a: "));
					expresion=expresion.replace("a", Integer.toString(a));
				}
				if(expresion.contains("b")) {
					int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de b: "));
					expresion=expresion.replace("b", Integer.toString(b));
				}
				if(expresion.contains("c")) {
					int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de c: "));
					expresion=expresion.replace("c", Integer.toString(c));
				}
				if(expresion.contains("d")) {
					int d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de d: "));
					expresion=expresion.replace("d", Integer.toString(d));
				}
				if(expresion.contains("f")) {
					int f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de f: "));
					expresion=expresion.replace("f", Integer.toString(f));
				}
				
				txtImprimirInorden.setText(expresion);
				ArbolExpresion arbol = new ArbolExpresion();
				String exp=txtImprimirInorden.getText();
				String resultado=Double.toString(arbol.evaluarExpresion(exp));
				ImprimirNotacionPolaca.setText(resultado);
				
					
			}
		});
		btnInorden.setBounds(10, 56, 96, 23);
		contentPane.add(btnInorden);
		
		txtImprimirPostorden = new JTextField();
		txtImprimirPostorden.setColumns(10);
		txtImprimirPostorden.setBounds(128, 89, 150, 21);
		contentPane.add(txtImprimirPostorden);
		
		txtImprimirPreorden = new JTextField();
		txtImprimirPreorden.setColumns(10);
		txtImprimirPreorden.setBounds(128, 121, 150, 21);
		contentPane.add(txtImprimirPreorden);
		
		JLabel NotacionPolaca = new JLabel("Notacion Polaca:");
		NotacionPolaca.setBounds(10, 149, 118, 21);
		contentPane.add(NotacionPolaca);
		
		ImprimirNotacionPolaca = new JTextField();
		ImprimirNotacionPolaca.setBounds(128, 149, 89, 21);
		contentPane.add(ImprimirNotacionPolaca);
		ImprimirNotacionPolaca.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(301, 55, 160, 203);
		contentPane.add(textArea);
		
		
	}
	}
