package ar.edu.unju.fi.ejercicio18.main;

import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pais> paises = new ArrayList<>();
        ArrayList<DestinoTuristico> destinos = new ArrayList<>();

        paises.add(new Pais("001", "Argentina"));
        paises.add(new Pais("002", "Brasil"));
        paises.add(new Pais("003", "Chile"));

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 - Alta de destino turístico");
            System.out.println("2 - Mostrar todos los destinos turísticos");
            System.out.println("3 - Modificar el país de un destino turístico");
            System.out.println("4 - Limpiar el ArrayList de destino turísticos");
            System.out.println("5 - Eliminar un destino turístico");
            System.out.println("6 - Mostrar los destinos turísticos ordenados por nombre");
            System.out.println("7 - Mostrar todos los países");
            System.out.println("8 - Mostrar los destinos turísticos que pertenecen a un país");
            System.out.println("9 - Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaDestinoTuristico(destinos, paises, scanner);
                    break;
                case 2:
                    mostrarDestinosTuristicos(destinos);
                    break;
                case 3:
                    modificarPaisDestino(destinos, paises, scanner);
                    break;
                case 4:
                    limpiarDestinosTuristicos(destinos);
                    break;
                case 5:
                    eliminarDestinoTuristico(destinos, scanner);
                    break;
                case 6:
                    mostrarDestinosOrdenados(destinos);
                    break;
                case 7:
                    mostrarPaises(paises);
                    break;
                case 8:
                    mostrarDestinosPorPais(destinos, scanner);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 9);

        scanner.close();
    }
    private static void altaDestinoTuristico(ArrayList<DestinoTuristico> destinos, ArrayList<Pais> paises, Scanner scanner) {
        System.out.println("\nAlta de destino turístico:");
        System.out.print("Código: ");
        String codigo = scanner.next();
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Código del país: ");
        String codigoPais = scanner.next();
        Pais pais = buscarPaisPorCodigo(paises, codigoPais);
        if (pais == null) {
            System.out.println("No se encontró ningún país con ese código.");
            return;
        }
        System.out.print("Cantidad de días: ");
        int cantidadDias = scanner.nextInt();

        DestinoTuristico destino = new DestinoTuristico(codigo, nombre, precio, pais, cantidadDias);
        destinos.add(destino);
        System.out.println("Destino turístico agregado correctamente.");
    }

    private static Pais buscarPaisPorCodigo(ArrayList<Pais> paises, String codigo) {
        for (Pais pais : paises) {
            if (pais.getCodigo().equals(codigo)) {
                return pais;
            }
        }
        return null;
    }

    private static void mostrarDestinosTuristicos(ArrayList<DestinoTuristico> destinos) {
        System.out.println("\nTodos los destinos turísticos:");
        for (DestinoTuristico destino : destinos) {
            System.out.println(destino);
        }
    }

    private static void modificarPaisDestino(ArrayList<DestinoTuristico> destinos, ArrayList<Pais> paises, Scanner scanner) {
        System.out.println("\nModificar el país de un destino turístico:");
        System.out.print("Ingrese el código del destino turístico: ");
        String codigoDestino = scanner.next();
        DestinoTuristico destino = buscarDestinoPorCodigo(destinos, codigoDestino);
        if (destino == null) {
            System.out.println("No se encontró ningún destino turístico con ese código.");
            return;
        }
        System.out.print("Nuevo código de país: ");
        String nuevoCodigoPais = scanner.next();
        Pais nuevoPais = buscarPaisPorCodigo(paises, nuevoCodigoPais);
        if (nuevoPais == null) {
            System.out.println("No se encontró ningún país con ese código.");
            return;
        }
        destino.setPais(nuevoPais);
        System.out.println("País del destino turístico modificado correctamente.");
    }

    private static DestinoTuristico buscarDestinoPorCodigo(ArrayList<DestinoTuristico> destinos, String codigo) {
        for (DestinoTuristico destino : destinos) {
            if (destino.getCodigo().equals(codigo)) {
                return destino;
            }
        }
        return null;
    }

    private static void limpiarDestinosTuristicos(ArrayList<DestinoTuristico> destinos) {
        destinos.clear();
        System.out.println("Lista de destinos turísticos limpiada correctamente.");
    }

    private static void eliminarDestinoTuristico(ArrayList<DestinoTuristico> destinos, Scanner scanner) {
        System.out.println("\nEliminar un destino turístico:");
        System.out.print("Ingrese el código del destino turístico: ");
        String codigoDestino = scanner.next();

        Iterator<DestinoTuristico> iterator = destinos.iterator();
        while (iterator.hasNext()) {
            DestinoTuristico destino = iterator.next();
            if (destino.getCodigo().equals(codigoDestino)) {
                iterator.remove();
                System.out.println("Destino turístico eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún destino turístico con ese código.");
    }

    private static void mostrarDestinosOrdenados(ArrayList<DestinoTuristico> destinos) {
        Collections.sort(destinos, (d1, d2) -> d1.getNombre().compareTo(d2.getNombre()));
        System.out.println("\nDestinos turísticos ordenados por nombre:");
        for (DestinoTuristico destino : destinos) {
            System.out.println(destino);
        }
    }

    private static void mostrarPaises(ArrayList<Pais> paises) {
        System.out.println("\nTodos los países:");
        for (Pais pais : paises) {
            System.out.println(pais);
        }
    }

    private static void mostrarDestinosPorPais(ArrayList<DestinoTuristico> destinos, Scanner scanner) {
        System.out.println("\nMostrar los destinos turísticos que pertenecen a un país:");
        System.out.print("Ingrese el código del país: ");
        String codigoPais = scanner.next();

        System.out.println("Destinos turísticos del país:");
        for (DestinoTuristico destino : destinos) {
            if (destino.getPais().getCodigo().equals(codigoPais)) {
                System.out.println(destino);
            }
        }
    }
}