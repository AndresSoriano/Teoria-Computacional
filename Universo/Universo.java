import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Universo{
	public static void main(String args[]){
		int k = 0, f = 0;
		Scanner S = new Scanner(System.in);
		k = pregunta (S);
		if (k == 1){
			System.out.println("valor de K");
			k = S.nextInt();
			proceso (k);
		}else{
			if(k==0){
				Random rand = new Random(System.nanoTime());
				k = rand.nextInt(1000);
				System.out.println("r = "+k);
				if(0 < k & k < 1001){
					proceso (k);
				}
			}
		}
	}

	public static int pregunta (Scanner s){
		int r = -1;
		System.out.println("Manual => 1\nAutomatico=>0");
		r = s.nextInt();
		return r;
	}

	public static void proceso (int valor){
		int tam = 0, f = 0, m, uni = 0, h = 0;
		ArrayList <String> alf = new ArrayList <String>();
		ArrayList <String> aux = new ArrayList <String>();
		String auxe;
		for(uni = 1; uni <= valor ; uni++){
			tam = calTam (uni);
			aux = creaArreglo (tam);
			h = alf.size();
			do{
				auxe = aux.remove(0);
				alf.add(h, auxe);
				h++;
			}while(aux.size() != 0);
		}
		f = alf.size();
		creaArchivo(alf, f, valor);
		System.out.print("\nTotal de elementos: " +f);
	}

	public static void creaArchivo (ArrayList AR, int tam, int valk){
		File Archivo;
		PrintWriter escribir;
		Archivo = new File("alfuni.txt");
		if(!Archivo.exists()){
			try{
				Archivo.createNewFile();
			}catch(Exception e){
			
			}
		}else{
			try{
				escribir = new PrintWriter(Archivo, "UTF-8");
				escribir.println("E-"+valk+"={");
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
		if(k > 0){
			for(i = 1; i < k; i++){
				l *= 2;
			}
		}else{
			return 0;
		}
		return l;
	}
	
	public static ArrayList creaArreglo (int tam){
		int j, g = 0, i, k, res = tam;
		ArrayList <String> AR = new ArrayList<String>();
		String aux;
		res/=2;
		/*if(tam == 0){
			AR.add(0, "e");
		}*/
		if(res > 0){
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
		}
		return AR;
	}
}
