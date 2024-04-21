package ar.edu.unju.fi.ejercicio17.main;

import ar.edu.unju.fi.ejercicio17.model.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Mostrar los datos del jugador");
            System.out.println("3 - Mostrar todos los jugadores ordenados por apellido");
            System.out.println("4 - Modificar los datos de un jugador");
            System.out.println("5 - Eliminar un jugador");
            System.out.println("6 - Mostrar la cantidad total de jugadores");
            System.out.println("7 - Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
            System.out.println("8 - Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarJugador(jugadores, scanner);
                    break;
                case 2:
                    mostrarDatosJugador(jugadores, scanner);
                    break;
                case 3:
                    mostrarJugadoresOrdenados(jugadores);
                    break;
                case 4:
                    modificarJugador(jugadores, scanner);
                    break;
                case 5:
                    eliminarJugador(jugadores, scanner);
                    break;
                case 6:
                    mostrarCantidadTotalJugadores(jugadores);
                    break;
                case 7:
                    mostrarCantidadPorNacionalidad(jugadores, scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static void agregarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("\nAlta de jugador:");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellido: ");
        String apellido = scanner.next();
        System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
        String fechaStr = scanner.next();
        Date fechaNacimiento;
        try {
            fechaNacimiento = new SimpleDateFormat("YYYY-MM-DD").parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Ingrese la fecha en el formato indicado.");
            return;
        }
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.next();
        System.out.print("Estatura: ");
        double estatura = scanner.nextDouble();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Posición (delantero, medio, defensa, arquero): ");
        String posicion = scanner.next();

        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador agregado correctamente.");
    }

    private static void mostrarDatosJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("\nMostrar los datos del jugador:");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                System.out.println(jugador);
                return;
            }
        }
        System.out.println("No se encontró al jugador con ese nombre y apellido.");
    }

    private static void mostrarJugadoresOrdenados(ArrayList<Jugador> jugadores) {
        Collections.sort(jugadores, Comparator.comparing(Jugador::getApellido));
        System.out.println("\nJugadores ordenados por apellido:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getApellido() + ", " + jugador.getNombre());
        }
    }

    private static void modificarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("\nModificar los datos de un jugador:");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                System.out.print("Nuevo nombre: ");
                jugador.setNombre(scanner.next());
                System.out.print("Nuevo apellido: ");
                jugador.setApellido(scanner.next());
                System.out.println("Datos del jugador modificados correctamente.");
                return;
            }
        }
        System.out.println("No se encontró al jugador con ese nombre y apellido.");
    }

    private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("\nEliminar un jugador:");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                iterator.remove();
                System.out.println("Jugador eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró al jugador con ese nombre y apellido.");
    }

    private static void mostrarCantidadTotalJugadores(ArrayList<Jugador> jugadores) {
        System.out.println("\nLa cantidad total de jugadores es: " + jugadores.size());
    }

    private static void mostrarCantidadPorNacionalidad(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("\nMostrar la cantidad de jugadores que pertenecen a una nacionalidad:");
        System.out.print("Ingrese la nacionalidad: ");
        String nacionalidad = scanner.next();

        int contador = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
                contador++;
            }
        }
        System.out.println("La cantidad de jugadores de la nacionalidad " + nacionalidad + " es: " + contador);
    }
}