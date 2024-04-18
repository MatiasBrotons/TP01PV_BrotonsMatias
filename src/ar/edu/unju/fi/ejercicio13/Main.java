package ar.edu.unju.fi.ejercicio13;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int[] array = new int[8];
		for (int i = 0; i < 8; i++) {
			System.out.print("Coloque un numero entero: ");
			array[i] = scanner.nextInt();
		}
		for (int j = 0; j < 8; j++) {
			System.out.println("El numero en la posicion: " + j + " " + "es: " + array[j]);
		}
		scanner.close();
	}

}
