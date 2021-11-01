package Automat;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.lang.Object;

public class Automata{

	int totalW = 0;//Contador total de palabras Web encontradas
	int totalE = 0;//Contador total de palabras Ebay encontradas

	/* Get del atributo totalW */
	public int getTotalW(){
		return totalW;
	}

	/* Get del atributo totalE */
	public int getTotalE(){
		return totalE;
	}

	public void eA(String cadena, int pos, int entrada, File Archivo, char dato, File history){
		if(cadena.length() != pos){
			dato = cadena.charAt(pos);
			if(dato == 'w'){
				if(pos == 0){
					entradas(entrada, history);
				}
				pos++;
				printHisto("A", dato, "B", history);
				this.eB(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'e'){
				if(pos == 0){
					entradas(entrada, history);
				}
				pos++;
				printHisto("A", dato, "C", history);
				this.eC(cadena, pos, entrada, Archivo, dato, history);
			}else{
				if(pos == 0){
					entradas(entrada, history);
				}
				pos++;
				printHisto("A", dato, "A", history);
				this.eA(cadena, pos, entrada, Archivo, dato, history);
			}
		}
	}

	public void eB(String cadena, int pos, int entrada, File Archivo, char dato, File history){
		if(cadena.length() != pos){
			dato = cadena.charAt(pos);
			if(dato == 'w'){
				pos++;
				printHisto("B", dato, "B", history);
				this.eB(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'e'){
				pos++;
				printHisto("B", dato, "D", history);
				this.eD(cadena, pos, entrada, Archivo, dato, history);
			}else{
				pos++;
				printHisto("B", dato, "A", history);
				this.eA(cadena, pos, entrada, Archivo, dato, history);
			}
		}
	}

	public void eC(String cadena, int pos, int entrada, File Archivo, char dato, File history){
		if(cadena.length() != pos){
			dato = cadena.charAt(pos);
			if(dato == 'w'){
				pos++;
				printHisto("C", dato, "B", history);
				this.eB(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'e'){
				pos++;
				printHisto("C", dato, "C", history);
				this.eC(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'b'){
				pos++;
				printHisto("C", dato, "E", history);
				this.eE(cadena, pos, entrada, Archivo, dato, history);
			}else{
				pos++;
				printHisto("C", dato, "A", history);
				this.eA(cadena, pos, entrada, Archivo, dato, history);
			}
		}
	}

	public void eD(String cadena, int pos, int entrada, File Archivo, char dato, File history){
		if(cadena.length() != pos){
			dato = cadena.charAt(pos);
			if(dato == 'w'){
				pos++;
				printHisto("D", dato, "B", history);
				this.eB(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'e'){
				pos++;
				printHisto("D", dato, "C", history);
				this.eC(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'b'){
				pos++;
				printHisto("D", dato, "F", history);
				this.eF(cadena, pos, entrada, Archivo, dato, history);
			}else{
				pos++;
				printHisto("D", dato, "A", history);
				this.eA(cadena, pos, entrada, Archivo, dato, history);
			}
		}
	}

	public void eE(String cadena, int pos, int entrada, File Archivo, char dato, File history){
		if(cadena.length() != pos){
			dato = cadena.charAt(pos);
			if(dato == 'w'){
				pos++;
				printHisto("E", dato, "B", history);
				this.eB(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'e'){
				pos++;
				printHisto("E", dato, "C", history);
				this.eC(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'a'){
				pos++;
				printHisto("E", dato, "G", history);
				this.eG(cadena, pos, entrada, Archivo, dato, history);
			}else{
				pos++;
				printHisto("E", dato, "A", history);
				this.eA(cadena, pos, entrada, Archivo, dato, history);
			}
		}
	}

	public void eF(String cadena, int pos, int entrada, File Archivo, char dato, File history){
		printPos(entrada, 1, Archivo);
		this.totalW++;
		if(cadena.length() != pos){
			dato = cadena.charAt(pos);
			if(dato == 'w'){
				pos++;
				printHisto("F", dato, "B", history);
				this.eB(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'e'){
				pos++;
				printHisto("F", dato, "C", history);
				this.eC(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'a'){
				pos++;
				printHisto("F", dato, "G", history);
				this.eG(cadena, pos, entrada, Archivo, dato, history);
			}else{
				pos++;
				printHisto("F", dato, "A", history);
				this.eA(cadena, pos, entrada, Archivo, dato, history);
			}
		}
	}

	public void eG(String cadena, int pos, int entrada, File Archivo, char dato, File history){
		if(cadena.length() != pos){
			dato = cadena.charAt(pos);
			if(dato == 'w'){
				pos++;
				printHisto("G", dato, "B", history);
				this.eB(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'e'){
				pos++;
				printHisto("G", dato, "C", history);
				this.eC(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'y'){
				pos++;
				printHisto("G", dato, "H", history);
				this.eH(cadena, pos, entrada, Archivo, dato, history);
			}else{
				pos++;
				printHisto("G", dato, "A", history);
				this.eA(cadena, pos, entrada, Archivo, dato, history);
			}
		}
	}

	public void eH(String cadena, int pos, int entrada, File Archivo, char dato, File history){
		printPos(entrada, 0, Archivo);
		this.totalE++;
		if(cadena.length() != pos){
			dato = cadena.charAt(pos);
			if(dato == 'w'){
				pos++;
				printHisto("H", dato, "B", history);
				this.eB(cadena, pos, entrada, Archivo, dato, history);
			}else if(dato == 'e'){
				pos++;
				printHisto("H", dato, "C", history);
				this.eC(cadena, pos, entrada, Archivo, dato, history);
			}else{
				pos++;
				printHisto("H", dato, "A", history);
				this.eA(cadena, pos, entrada, Archivo, dato, history);
			}
		}
	}

	public void printPos(int entrada, int palabra, File Archivo){
		PrintWriter escribir;
		if(palabra == 1){
			try{
				FileWriter linea = new FileWriter(Archivo, true);
				escribir = new PrintWriter(linea);
				escribir.println("Palabra -Web - encontrada en linea: " + entrada);
				escribir.close();
			}catch(Exception e){
			}
		}else if(palabra == 0){
			try{
				FileWriter linea = new FileWriter(Archivo, true);
				escribir = new PrintWriter(linea);
				escribir.println("Palabra -ebay- encontrada en linea: " + entrada);
				escribir.close();
			}catch(Exception e){
			}
		}
	}

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
}
