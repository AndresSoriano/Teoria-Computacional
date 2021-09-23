import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Primos{
	public static void main(String args[]){
		int k = 0, f = 0, size = 0;
		Scanner S = new Scanner(System.in);
		k = pregunta (S);
		ArrayList <Integer> auxi = new ArrayList <Integer>();
		ArrayList <String> auxb = new ArrayList <String>();
		if (k == 1){
			auxi = esPrimo();
			size = auxi.size();
			creaArchivo (auxi, size, 1);
			auxb = primoBin(auxi);
			size = auxb.size();
			creaArchivo (auxb, size, 0);
		}else{	}
	}

	/*Inidica que esta listo para iniciar*/
	public static int pregunta (Scanner s){
		int r = -1;
		System.out.println("1 -- Comenzar");
		r = s.nextInt();
		return r;
	}

	public static void creaArchivo (ArrayList AR, int tam, int archiv){
		File Archivo;
		PrintWriter escribir;
		if(archiv == 1){
			Archivo = new File("primos.txt");//Declaración para crear un archivo y guardar los numeros primos
		}
		else{
			Archivo = new File("binprimo.txt");//Declaración para archivo y guardar numeros primos en binario
		}
		if(!Archivo.exists()){
			try{
				Archivo.createNewFile();//Creación del archivo
			}catch(Exception e){
			}
		}else{
			try{
				System.out.println("... Trabajando ...");
				escribir = new PrintWriter(Archivo, "UTF-8");
				for(int m = 0; m < tam; m++){
					escribir.print(AR.get(m));
				}
				escribir.close();
			}catch (Exception e){
			}
		}
	}
	
	/*Método para transformar los números primos de decimal a binario*/
	public static ArrayList primoBin(ArrayList <Integer> primos){
		ArrayList <String> auxb = new ArrayList<String>();
		int i = 0, aux = 0, c = 0, dato = 0;
		String nbin = "";
		int tam = primos.size();
		File Archivo;
		PrintWriter escribir;
		Archivo = new File("binprimo.txt");
		do{
			dato = primos.get(c);
			while(dato > 0){
				if(dato % 2 == 0){
					nbin = "0" + nbin;
				}else{
					nbin = "1" + nbin;
				}
				dato = (int) dato/ 2;
			}
			auxb.add(nbin);
			nbin = "";
			c++;
		}while(c < tam);
		return auxb;
	}

	/*Obtención de los numeros primos*/
	public static ArrayList esPrimo(){
		int ini = 2, fin = 100;
		int i, j, k = 0, l = 0;
		boolean primo;
		ArrayList <Integer> ARP = new ArrayList <Integer>();
		for(i  = ini ; i <fin ; i++){
			primo=true;
			for(j = 2; j < i; j++){
				if( i  %  j == 0){
					primo = false;
				}			
			}
			if(primo){
				ARP.add(l, i);
				l++;
			}
		}
		return ARP;
	}
}
