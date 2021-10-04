/* @author Soriano Montiel Bryan Andrés */

import java.util.Scanner;
import java.util.Random;
import java.lang.Object;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import Automat.*; //Carga la clase de Automata

public class Main{
	
	/* Metodo principal */
	public static void main(String args[]){
		Scanner S = new Scanner(System.in);
		int resp = -1;
		resp = menu(S);
		Proceso(resp);	
	}

	/*Menu que indica si el archivo de donde se leeran las palabras a clasificar ya existe o
	*si se creara un archivo nuevo, y se llenara cn palabras al azar, para su clasificación*/
	public static int menu(Scanner S){
		System.out.println("1--Crear archivo\n0--Archivo ya Existe\n");
		int res = S.nextInt();
		return res;
	}

	/*Inicia el proceso del programa*/
	public static void Proceso(int resp){
		int lim = 25, i = 0, pos = 0, entrada = 1;
		String cadena = "";
		PrintWriter escribir;
		File Archivo, Negado, Acept, history;
		if(resp == 1){
			Archivo = creaArchivo(cadena);//Llamada para la Creacion del archivo para su lectura y clasificación
		}

		Acept = new File("Aceptadas.txt");
		Negado = new File("Rechazados.txt");
		history = new File("Historial.txt");
		try{
			Acept.createNewFile();
		}catch(Exception e){
		}
		try{
			Negado.createNewFile();
		}catch(Exception e){
		}
		try{
			history.createNewFile();
		}catch(Exception e){
		}
		/*Inicio del proceso con el Automata*/
		Automata leer = new Automata();
		i=0;
		try{
			FileReader r = new FileReader("Cadenas.txt");//Apertura del archivo
			BufferedReader buffer = new BufferedReader(r);//Buffer de entrada
			do{
				cadena = buffer.readLine();//Lectura del archivo
				leer.q0(cadena, pos, entrada, Negado, Acept, history);//Inicio con el estado inicial q0
				entrada++;
			}while(i < lim);
		}catch(Exception e){
		}
	}
	
	/*Para la  creación del archivo del cual se lleran las palabras a clasificar */
	public static File creaArchivo(String cadena){
		File Archivo;
		PrintWriter escribir;
		Archivo = new File("Cadenas.txt");
		int i = 0;
		if(!Archivo.exists()){
			try{
				Archivo.createNewFile();
			}catch(Exception e){
			}
		}else{
			try{
				escribir = new PrintWriter(Archivo, "UTF-8");
				do{
					cadena = cadenas();//Genración de las cadenas para rellenar el archivo
					escribir.println(cadena);//Escritura en el archvio
				}while(i < 25);
				escribir.close();
			}catch (Exception e){
			}
		}
		return Archivo;
	}
	
	/*Modulo para generar las palabras del nuevo archivo*/
	public static String cadenas(){
		Random rand = new Random(System.nanoTime());
		int i = 0, lim = 32, dat;
		String cadena="";
		do{
			dat = rand.nextInt(1);
			cadena += dat;
			i++;		
		}while(i < lim);
		return cadena;
	}
}
