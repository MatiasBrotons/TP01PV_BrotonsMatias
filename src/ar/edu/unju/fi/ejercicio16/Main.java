package ar.edu.unju.fi.ejercicio16;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] array = new String[5];
		for (int j = 0; j < array.length; j++) {
			System.out.print("Ingrese un nombre de una persona: ");
			array [j] = scanner.nextLine();
		}
		int i = 0;
		while(i < array.length) {
			System.out.println(array[i]);
			i++;
		}
		System.out.println("El tamaño del array es: " + array.length);
		
		byte indice;
		
        do {
            System.out.print("Ingrese el índice del elemento a eliminar (0-4): ");
            indice = scanner.nextByte();
        } while (indice < 0 || indice >= array.length);

        array[indice] = "";
        
		for (i = 0; i < array.length; i++) {
            if (!array[i].equals("")) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print("\t");
                }
            }
        }
		System.out.println("");
        for (i = 0; i < array.length; i++) {
            System.out.print(i);
            if (i < array.length - 1) {
                System.out.print("\t");
            }
        }		
        scanner.close();
	}

}
