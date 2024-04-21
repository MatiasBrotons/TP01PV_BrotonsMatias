package ar.edu.unju.fi.ejercicio15;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un numero entre el 5 y el 10: ");
		int i = scanner.nextInt();
		
		String[] array = new String[i];
		
		for (int j = 0; j < array.length; j++) {
			System.out.print("Ingrese un nombre de una persona: ");
			array [j] = scanner.next();
			
		}
		scanner.close();
		 for (int j = 0; j < array.length; j++) {
	            System.out.println("Posición " + j + ": " + array[j]);
	        }
		 
		 for (int j = array.length - 1; j >= 0; j--) {
	            System.out.println("Posición " + j + ": " + array[j]);
	        }
		
	}

}
