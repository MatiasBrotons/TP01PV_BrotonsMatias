package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n, i;
		System.out.println ("Ingrese un numero entre el 0 y el 10: ");
		n = scanner.nextInt();
		scanner.close();
		i = n - 1;
		while(i > 0) {
			n = n * i;
			i--;
		}
		System.out.println ("el factorial del numero es: " + n);
	}

}
