package ar.edu.unju.fi.ejercicio12.main;
import java.util.Scanner;
import java.util.Calendar;
import ar.edu.unju.fi.ejercicio12.model.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la persona: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento (formato dd/mm/aaaa): ");
        System.out.print("Día: ");
        int dia = scanner.nextInt();
        System.out.print("Mes: ");
        int mes = scanner.nextInt() - 1;
        System.out.print("Año: ");
        int año = scanner.nextInt();

        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(año, mes, dia);

        Persona persona = new Persona(nombre, fechaNacimiento);

        System.out.println("Datos de la persona:");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Fecha de nacimiento: " + dia + "/" + (mes + 1) + "/" + año);
        System.out.println("Edad: " + persona.calcularEdad() + " años");
        System.out.println("Signo del zodiaco: " + persona.obtenerSignoZodiaco());
        System.out.println("Estación: " + persona.obtenerEstacion());
        
        scanner.close();
    }
}