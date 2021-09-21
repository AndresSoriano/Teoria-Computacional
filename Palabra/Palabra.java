import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

/*Las palabras son base binaria, es decir, solo 1 y 0*/
public class Palabra{
	public static void main(String args[]){
		int k = 0, f = 0;
		Scanner S = new Scanner(System.in);
		k = pregunta (S);//Regresa Tamaño de las palabras a generar
		if (k == 1){
			System.out.println("valor de K");
			k = S.nextInt();//Agregamos el tamaño de la palabra
			proceso (k);//Proceso de generacion de palabras
		}else{
			if(k==0){
				Random rand = new Random(System.nanoTime());
				k = rand.nextInt(1000);//se genera un tamaño de palabra aleatorio
				System.out.println("r = "+k);
				if(0 < k & k < 1001){
					proceso (k);//Proceso de generacion de palabras
				}
			}
		}
	}

	public static int pregunta (Scanner s){
		int r = -1;
		//Manual - agregamos el tamaño de la palabra nosotros
		//Automatico - Se genera un tamaño de palabra aleatorio
		System.out.println("Manual => 1\nAutomatico=>0");
		r = s.nextInt();
		return r;
	}

	public static void proceso (int valor){
		int tam = 0, f = 0, m;
		ArrayList <String> alf = new ArrayList <String>();
		tam = calTam (valor);
		alf = creaArreglo (tam);
		f = alf.size();
		creaArchivo(alf, f, valor);
		System.out.print("\nTotal de elementos: " +f);
	}

	public static void creaArchivo (ArrayList AR, int tam, int k){
		File Archivo;
		PrintWriter escribir;
		Archivo = new File("alfabeto.txt");
		if(!Archivo.exists()){
			try{
				Archivo.createNewFile();
			}catch(Exception e){
			
			}
		}else{
			try{
				escribir = new PrintWriter(Archivo, "UTF-8");
				escribir.println("E-"+k+"={");
				for(int m = 0; m < tam; m++){
					escribir.println(AR.get(m));
				}
				escribir.println("}");
				escribir.close();
			}catch (Exception e){

			}
		}
	}

	public static int calTam (int k){
		int i, l = 2;
		System.out.println("k = " +k);
		for(i = 1; i < k; i++){
			l *= 2;
		}
		System.out.println("valor l final: " +l);
		return l;
	}
	
	public static ArrayList creaArreglo (int tam){
		int j, g = 0, i, k, res = tam;
		ArrayList <String> AR = new ArrayList<String>();
		String aux;
		res/=2;
			for(i = 0; i < res; i++){
				AR.add(0, "0");				
			}
			for(k = res; k < tam; k++){
				AR.add(k, "1");
			}
			if(res>0){
				res/=2;
				do{
					for(i = 0; i < res; i++){
						aux = AR.remove(g);
						aux += "0";
						AR.add(g, aux);
						g++;
					}
					for(k = 0; k < res; k++){
						aux = AR.remove(g);
						aux += "1";
						AR.add(g, aux);
						g++;
					}
					if( g == tam){
						res /=2;
						g = 0;
					}
				}while(res > 0);
			}
		return AR;
	}
}
