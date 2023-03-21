# DOCUMENTACION
1. IDE que se utilizo Eclipse java
2. La aplicacion recibira en una caja de texto una expresion matematica limitada
como sumas, restas, multiplicaciones, diviciones y raices.
3. La aplicacion tiene la capacidad de validar caracteres permitidos para evitar excepciones
"((?<=[-+*/√^()])|(?=[-+*/√^()]))" y "[0-9]+(\\\\.[0-9]+)?"
4. Tiene la capacidad de evaluar si son variables como a, b, c, d y f para poderlas
sustituir por numeros.
5. Podra recorrer el metodo inOrden
6. los metodos postOrden y preOrden fueron implementados pero no se lograron mostrar
en la caja de texto ya que son de tipo void.

## Clase Nodo
1. Nos permite almacenar informacion de cualquier tipo (int, char, String)

### Clase ArbolExpresion
1. Dentro de esta clase se encuentra el metodo para evaluaar la expresion del recorrido
   postOrden este recorrido como notacion polaca o postfija 

2. Nos permite evaluar una expresion matematica y mostrar su resultado

### Clase Jframe
1. Esta clase nos permitira crear nuestra interfaz grafica GUI
2. Dentro de ella se encuentra el diseño donde ingresamos la expresion matematica y 
luego nos permite evaluar la expresion obtener su resultado y tambien cuenta con
botones donde nos permite evaluar el tipo de recorrido
3. Tambien permite ingresar una expresion con letras para luego sustituirlas por numeros
el tipo de letras permitido son (a, b, c, d, f)
4. Para ingresar una expresion es necesario que se inicie con un parentesis "(" de apertura
como un parentesis de cierre ")".

#### Clase Main 
1. Nos permite ejecutar nuestra aplicacion
2. Click derecho y RUN AS o bien en el boton verde que se encuentra en la parte izquierda 
de nuestro ID

