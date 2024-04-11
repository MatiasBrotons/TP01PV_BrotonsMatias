package ar.edu.unju.fi.ejercicio6.main;
import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio6.model.Persona;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación de objeto utilizando el constructor por defecto
        Persona persona1 = new Persona();
        System.out.println("Ingrese DNI:");
        persona1.setDni(scanner.nextLine());
        System.out.println("Ingrese Nombre:");
        persona1.setNombre(scanner.nextLine());
        System.out.println("Ingrese Fecha de Nacimiento (YYYY-MM-DD):");
        persona1.setFechaNacimiento(LocalDate.parse(scanner.nextLine()));
        persona1.mostrarDatos();

        System.out.println("----------------------------------");

        System.out.println("Ingrese DNI:");
        String dni = scanner.nextLine();
        System.out.println("Ingrese Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese Fecha de Nacimiento (YYYY-MM-DD):");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese Provincia:");
        String provincia = scanner.nextLine();
        Persona persona2 = new Persona(dni, nombre, fechaNacimiento, provincia);
        persona2.mostrarDatos();

        System.out.println("----------------------------------");

        System.out.println("Ingrese DNI:");
        dni = scanner.nextLine();
        System.out.println("Ingrese Nombre:");
        nombre = scanner.nextLine();
        System.out.println("Ingrese Fecha de Nacimiento (YYYY-MM-DD):");
        fechaNacimiento = LocalDate.parse(scanner.nextLine());
        Persona persona3 = new Persona(dni, nombre, fechaNacimiento);
        persona3.mostrarDatos();

        scanner.close();
    }
}
