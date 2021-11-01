/* @author Soriano Montiel Bryan Andrés */

import java.util.Scanner;
import java.util.Random;
import java.lang.Object;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import Automat.*; //Modulo para cargar la clase Automata

public class Main{
	
	/* Método principal inicial */
	public static void main(String args[]){
		Scanner S = new Scanner(System.in);
		int resp = -1;
		resp = menu(S);
		if(resp == 1){
			funcionamiento(resp);
		}
	}

	/* Menu sencillo de iniciar o salir */
	public static int menu(Scanner S){
		System.out.println("Buscador de Palabras\n1 - Comenzar\n0 - Salir");
		int res = S.nextInt();
		return res;
	}

	/* Método funcionamiento principal del programa
	*Donde se realiza el proceso de escritura de los archivos,
	*y la entrada al atutomata
	*/
	public static void funcionamiento(int resp){
		int i = 0, pos = 0, entrada = 1, lim = 25;
		String cadena = "";
		PrintWriter escribir;
		File Archivo, history;
		Archivo = new File("Salida.txt");
		history = new File("Historial.txt");

		try{
			Archivo.createNewFile();
		}catch(Exception e){
		}
		try{
			history.createNewFile();
		}catch(Exception e){
		}

		Automata leer = new Automata();
		try{
			FileReader r = new FileReader("WEB.txt");
			BufferedReader buffer = new BufferedReader(r);
			do{
				pos = 0;
				char dato=' ';
				cadena = buffer.readLine();
				leer.eA(cadena, pos, entrada, Archivo, dato, history);
				entrada++;
				i++;
			}while(cadena != null);
			
		}catch(Exception e){
		}
		printTotal(leer, Archivo);
	}

	/* Método final, imprimira en un archivo los datos del proceso
	*@param leer: Automata Instancia del automata que realizo el analisis del texto
	*@param arcihvo: File, Archivo en el que se anotaran el tortal de palabras encontradas
	*/
	public static void printTotal(Automata leer, File Archivo){
		PrintWriter escribir;
		try{
			FileWriter linea = new FileWriter(Archivo, true);
			escribir = new PrintWriter(linea);
			escribir.println("Total de palabras -WEB -: " + leer.getTotalW());
			escribir.println("Total de palabras -EBAY-: " + leer.getTotalE());
			escribir.close();
		}catch(Exception e){
		}
	}
	
}