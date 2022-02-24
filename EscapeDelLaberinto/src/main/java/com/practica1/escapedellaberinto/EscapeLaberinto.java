package com.practica1.escapedellaberinto;

import java.util.Scanner;

/**
 *
 * @author michael
 */
public class EscapeLaberinto {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("**********************");
        System.out.println("*ESCAPE DEL LABERINTO*");
        System.out.println("**********************");

        menuPrincipal();

    }

    public static void menuPrincipal() {
        int opcion;
        do {

            System.out.println("\n-Menú Principal-");
            System.out.println("1. Jugar\n2. Crear Mapa\n3. Reportes\n4. Visualizar Mapas\n5. Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("**********************");
                    jugar();
                    break;

                case 2:
                    System.out.println("**********************");
                    creacionMapas();
                    break;

                case 3:
                    System.out.println("**********************");
                    reportes();
                    break;

                case 4:
                    System.out.println("**********************");
                    visualizarMapas();
                    break;

                case 5:
                    System.out.println("**********************");
                    System.out.println("-Saliendo del Juego-");
                    break;

                default:
                    System.out.println("Número de opcion ingresado invalido");
            }

        } while (opcion != 5);

    }

    public static void jugar() {
        int opcion;

        System.out.println("1. Elija un mapa");
        System.out.println("2. Regresar al Menu Principal");
        opcion = entrada.nextInt();

        if (opcion == 1) {

        } else {
            menuPrincipal();

        }

    }

    public static void creacionMapas() {
        int eleccion;

        System.out.println("Presione 1 si desea crear un mapa nuevo");
        System.out.println("Presione 2 si desea regresar al Menu Principal");
        eleccion = entrada.nextInt();

        if (eleccion == 1) {
            crearMapa();

        } else {
            System.out.println("Regresando al Menú Principal ... ...");
            menuPrincipal();
        }

    }

    public static void crearMapa() {
        int numeroFilas;
        int numeroColumnas;
        
        System.out.println("Defina el tamaño del laberinto que desea ingresando los siguientes datos:");
        System.out.print("Número de filas: ");
        numeroFilas = entrada.nextInt();
        System.out.print("Número de columnas: ");
        numeroColumnas = entrada.nextInt();
        
        int tamañoMapa[][] = new int[numeroFilas][numeroColumnas];
        String nombreMapa[] = new String[10];
        int listadoMapas[] = new int[10];
        String mapaInicial = "Mapa Inicial";
        int posicionMapaInicial = 0;
        int indice = 1;
        
        nombreMapa[0] = mapaInicial;
        listadoMapas[0] = posicionMapaInicial;
        
        for (int i = 0; i < numeroFilas; i++) {
            System.out.println("   ");
            
            for (int j = 0; j < numeroColumnas; j++) {
                System.out.println("#   #");
                System.out.println(tamañoMapa[i][j]);
                
            }
        }
        tamañoMapa[numeroFilas][numeroColumnas] = listadoMapas[indice];
        
        System.out.print("Colóquele un nombe al mapa que acaba de crear: ");
        nombreMapa[indice] = entrada.next();
    }

    public static void reportes() {

    }

    public static void visualizarMapas() {

    }
}
