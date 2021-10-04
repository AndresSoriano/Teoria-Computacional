/* @author Soriano Montiel Bryan Andrés */

package Automat;//Declaracion del paquete
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.lang.Object;

public class Automata{

	/*
	*Estado inicial y final del automata, evaluara caracter de la cadena y decidira el estado a moverse
	*En caso de que la lectura de los caracteres termine en este estado, se actualiza el archivo "Aceptadas"
	*En caso de haber más caracteres decide a que estado se dirigira, así mismo actualiza en archivo "Historial"
	*@param cadena String representa la palabra a evaluar, y se asignara a un archivo dependiendo el resultado
	*@param pos int posición actual dentro de la palabra, sabiendo así si aun hay caracteres a evaluar
	*@param entrada int Nos indica las veces que el automata ha realizado el analisis de palabras, usado para el archivo de "Historial"
	*@param Neg File referencia al archivo de Negadas
	*@param Ace File referencia al archivo de aceptadas
	*@param his File referencia al archivo de Historial
	*/
	public void q0(String cadena, int pos, int entrada, File Neg, File Ace, File his){
		if(cadena.length() != pos){
			char dato = cadena.charAt(pos);
			if(dato == '1'){
				if(pos == 0){
					entradas(entrada, his);
				}
				pos++;
				printHisto("q0", dato, "q1", his);
				this.q1(cadena, pos, entrada, Neg, Ace, his);
			}else if(dato == '0'){
				if(pos == 0){
					entradas(entrada, his);
				}
				pos++;
				printHisto("q0", dato, "q2", his);
				this.q2(cadena, pos, entrada, Neg, Ace, his);
			}
		}else{ if(cadena.length() == pos){
				try{
					FileWriter linea = new FileWriter(Ace, true);
					PrintWriter escribir = new PrintWriter(linea);
					escribir.println(cadena);
					escribir.close();
				}catch (Exception e){
				}
			}
		}
	}

	/*
	*Segundo estado del automata, al cual se llega si el dato a analizar es un "1"
	*En caso de que la lectura de los caracteres termine en este estado, se actualiza el archivo "Rechazados"
	*En caso de haber más caracteres decide a que estado se dirigira, así mismo actualiza en archivo "Historial"
	*@param cadena String representa la palabra a evaluar, y se asignara a un archivo dependiendo el resultado
	*@param pos int posición actual dentro de la palabra, sabiendo así si aun hay caracteres a evaluar
	*@param entrada int Nos indica las veces que el automata ha realizado el analisis de palabras, usado para el archivo de "Historial"
	*@param Neg File referencia al archivo de Negadas
	*@param Ace File referencia al archivo de aceptadas
	*@param his File referencia al archivo de Historial
	*/
	public void q1(String cadena, int pos, int entrada, File Neg, File Ace, File his){
		if(cadena.length() != pos){
			char dato = cadena.charAt(pos);		
			if(dato == '1'){
				pos++;
				printHisto("q1", dato, "q0", his);
				this.q0(cadena, pos, entrada, Neg, Ace, his);
			}else if(dato =='0'){
				pos++;
				printHisto("q1", dato, "q3", his);
				this.q3(cadena, pos, entrada, Neg, Ace, his);
			}
		}else{ if(cadena.length() == pos){
				try{
					FileWriter linea = new FileWriter(Neg, true);
					PrintWriter escribir = new PrintWriter(linea);
					escribir.println(cadena);
					escribir.close();
				}catch(Exception e){
				}
			}
		}
	}

	/*
	*Tercer estado del automata, al cual se llega si el dato a analizar es un "0"
	*En caso de que la lectura de los caracteres termine en este estado, se actualiza el archivo "Rechazados"
	*En caso de haber más caracteres decide a que estado se dirigira, así mismo actualiza en archivo "Historial"
	*@param cadena String representa la palabra a evaluar, y se asignara a un archivo dependiendo el resultado
	*@param pos int posición actual dentro de la palabra, sabiendo así si aun hay caracteres a evaluar
	*@param entrada int Nos indica las veces que el automata ha realizado el analisis de palabras, usado para el archivo de "Historial"
	*@param Neg File referencia al archivo de Negadas
	*@param Ace File referencia al archivo de aceptadas
	*@param his File referencia al archivo de Historial
	*/
	public void q2(String cadena, int pos, int entrada, File Neg, File Ace, File his){
		if(cadena.length() != pos){
			char dato = cadena.charAt(pos);
			if(dato == '1'){
				pos++;
				printHisto("q2", dato, "q3", his);
				this.q3(cadena, pos, entrada, Neg, Ace, his);
			}else if(dato == '0'){
				pos++;
				printHisto("q2", dato, "q0", his);
				this.q0(cadena, pos, entrada, Neg, Ace, his);
			}
		}else{ if(cadena.length() == pos){
				try{
					FileWriter linea = new FileWriter(Neg, true);
					PrintWriter escribir = new PrintWriter(linea);
					escribir.println(cadena);
					escribir.close();
				}catch(Exception e){
				}
			}
		}
	}

	/*
	*Cuarto estado del automata, al cual se llega si el dato a analizar es un "1", esto si se viene del estado "q2"
	*Emn caso de estar en el estado "q1", se llega si el dato a analizar es un "0"
	*En caso de que la lectura de los caracteres termine en este estado, se actualiza el archivo "Rechazados"
	*En caso de haber más caracteres decide a que estado se dirigira, así mismo actualiza en archivo "Historial"
	*@param cadena String representa la palabra a evaluar, y se asignara a un archivo dependiendo el resultado
	*@param pos int posición actual dentro de la palabra, sabiendo así si aun hay caracteres a evaluar
	*@param entrada int Nos indica las veces que el automata ha realizado el analisis de palabras, usado para el archivo de "Historial"
	*@param Neg File referencia al archivo de Negadas
	*@param Ace File referencia al archivo de aceptadas
	*@param his File referencia al archivo de Historial
	*/
	public void q3(String cadena, int pos, int entrada, File Neg, File Ace, File his){
		if(cadena.length() != pos){
			char dato = cadena.charAt(pos);
			if(dato == '1'){
				pos++;
				printHisto("q3", dato, "q2", his);
				this.q2(cadena, pos, entrada, Neg, Ace, his);
			}else if(dato == '0'){
				pos++;
				printHisto("q3", dato, "q1", his);
				this.q1(cadena, pos, entrada, Neg, Ace, his);
			}
		}else{ if(cadena.length() == pos){
				try{
					FileWriter linea = new FileWriter(Neg, true);
					PrintWriter escribir = new PrintWriter(linea);
					escribir.println(cadena);
					escribir.close();
				}catch(Exception e){
				}
			}
		}
	}

	/*
	*Metodo en el cual hacemos una pqeueña modificación a nuestro archivo de texto "Historial"
	*Con este agregamos el numero de entrada del automata, es decir, las veces que se ha iniciado.
	*@param entrada int Es el numero de la entrada de analisis de una palabra en el automata
	*@param his File Es la referencia de nuestro archivo a modificar "Historial"
	*/
	public void entradas(int entrada, File his){
		PrintWriter escribir;
		try{
			FileWriter linea = new FileWriter(his, true);
			escribir = new PrintWriter(linea);
			escribir.println("No. de entrada al Automata: ["+entrada+"]");
			escribir.close();
		}catch (Exception e){
		}
	}
	
	/*
	*Metodo el cual estara actualizando nuestro archivo "Historial", indicando el estado actual,
	*el dato analizado y el estado al que se estara dirigiendo.
	*@param eActual String Nos dice el estado actual en el que se encuentra el automata.
	*@param dato char Es el dato que se esta analisando en el estado actual.
	*@param eDestino String Es el estado al que se dirigira el automata con base el dato analizado.
	*@param his File Es la referencia a nuestro archivo a modificar "Historial".
	*/
	public void printHisto(String eActual, char dato, String eDestino, File his){
		PrintWriter escribir;
		try{
			FileWriter linea = new FileWriter(his, true);
			escribir = new PrintWriter(linea);
			escribir.println(eActual + ":" + dato +"->" + eDestino);
			escribir.close();
		}catch (Exception e){
		}
	}
}
