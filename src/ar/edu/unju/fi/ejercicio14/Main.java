package ar.edu.unju.fi.ejercicio14;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un numero entre el 3 y el 10: ");
		int i = scanner.nextInt();
		int suma = 0;
		int[] array = new int[i];
		for (int j = 0; j < i; j++) {
			System.out.print("Ingrese un numero entero: ");
			array [j] = scanner.nextInt();
			suma = suma + array[j];
		}
		for (int j = 0; j < i; j++) {
		System.out.println("El numero en la posicion: " + j + " " + "es: " + array[j]);
	}
		System.out.println("La suma total de los numeros es: " + suma);
		scanner.close();
	}
}
