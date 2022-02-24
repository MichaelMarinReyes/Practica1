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
                    reporteGeneral();
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
        int subMenu;
        char jugador = 'J';
        char bot = 'B';
        char vacio = 'O';
        char oro = 'G';
        char salida = 'S';
        char pared = '#';

        System.out.println("1. Elejir un mapa");
        System.out.println("2. Regresar al Menu Principal");
        subMenu = entrada.nextInt();

        if (subMenu == 1) {
            
            reportesFinales();

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
            //        mapasAlmacenados();
            tamañoMapa();

        } else {
            System.out.println("Regresando al Menú Principal ... ...");
            menuPrincipal();
        }

    }

    public static void juego() {
        reportesFinales();

    }

    public static void mapasAlmacenados(String nombre, int posicionGuardado) {
        int indice = 0;
        String nombreMapa[] = new String[indice];
        int mapaCreado[] = new int[indice];

        nombre = nombreMapa[indice];
        posicionGuardado = mapaCreado[indice];
        indice += 1;

        for (int i = 0; i < nombreMapa.length; i++) {
            System.out.println(nombreMapa[i]);
        }

        jugar();
    }

    public static void tamañoMapa() {
        int numeroFilas;
        int numeroColumnas;

        System.out.println("Defina el tamaño del laberinto que desea ingresando los siguientes datos:");
        System.out.print("Número de filas: ");
        numeroFilas = entrada.nextInt();
        System.out.print("Número de columnas: ");
        numeroColumnas = entrada.nextInt();

        int mapa[][] = new int[numeroFilas][numeroColumnas];
        int posicionGuardado = 1;
        String nombre;

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                System.out.println(mapa[i][j]);

            }
            System.out.println("");
        }
        mapa[numeroFilas][numeroColumnas] = posicionGuardado;
        posicionGuardado += 1;
        System.out.print("Escriba un nombre con el que desea guardar el mapa: ");
        nombre = entrada.next();

        mapasAlmacenados(nombre, posicionGuardado);

    }

     public static void visualizarMapas() {

    }
     /*
    public static void comandos() {
        String comando;
        String inexistente;

        do {

            System.out.println("Ingrese uno de los siguientes comandos\nPuede escribir algunos de los siguientes comandos en mayúscula y minúscula");
            System.out.println("ORO_REQUERIDO = Muestra cantidad de oro que se necesita para las salidas del laberinto");
            System.out.println("ORO = Muestra la cantidad de oro que posee");
            System.out.println("MOVER = Para avanzar posiciónes");
            System.out.println("LEVANTAR = Para levantar el oro encontrado");
            System.out.println("MIRAR = Muestra la posición del Jugador y los caminos que podría seguir");
            System.out.println("SALIR = Al llegar a una de las salidas puede ingresar el comando y terminar el juego");
            comando = entrada.next();

            if (comando == ORO_REQUERIDO || comando == oro_requerido) {
                oroRequerido();

            } else if (comando == ORO || comando == oro) {

            } else if (comando == MOVER || comando == mover) {

            } else if (comando == LEVANTAR || comando == levantar) {

            } else if (comando == MIRAR || comando == mirar) {

            } else if (comando == SALIR || comando == salir) {

            } else {
                System.out.println("Comando ingresado inexistente, vuelva a intentarlo");

            }

        } while (comando != inexistente);

    }

    public static void oroRequerido() {
        int cantidadOro;
        int oro = 0;

        System.out.println("Oro actual: " + oro);
    }

    public static void movimiento() {
        char direccion;

        System.out.println("Para moverse a alguna dirección debe escribir MOVER ó mover seguidamente de la dirección que desea tomar");
        System.out.println("MOVER A");
        System.out.println("Para moverse una casilla hacia arriba puede escribir A ó a");
        System.out.println("Para moverse una casilla hacia arriba puede escribir A ó a");
        System.out.println("Para moverse una casilla hacia la derecha puede escribir E ó e");
        System.out.println("Para moverse una casilla hacia la izquierda puede escribir O u o");
        direccion = entrada.next().charAt(0);

        if (direccion == A || direccion == a) {
            //mover arriba

        } else if (direccion == S || direccion == s) {
            //mover abajo

        } else if (direccion == E || direccion == e) {
            //mover derecha            

        } else if (direccion == O || direccion == o) {
            //mover izquierda

        }
    }

    public static void levantar() {
        int oroLevantado = 0;

        System.out.println("Oro levantado: " + oroLevantado);
    }

    public static void oro() {
        int oroTotal = 0;

        System.out.println("Oro: " + oroTotal);
    }
*/
    public static void reportesFinales() {
        int oroRecolectado = 0;
        int movimientosRealizados = 0;
        int movimientosBot = 0;
        int vistoPorBot = 0;

        System.out.println("*Estadísticas finales*");
        System.out.println("Oro recolectado: " + oroRecolectado);
        System.out.println("Movimientos realizados: " + movimientosRealizados);
        System.out.println("Movimientos realizados por el Bot: " + movimientosBot);
        System.out.println("Intentos de captura: " + vistoPorBot);

    }

    public static void reporteGeneral() {
        int vecesAtrapado = 0;
        int partidasGanadas = 0;
        int promedioOro = 0;
        int promedioMovimiento = 0;
        String mapaMasJugado = "";
        String masPerdido = "";
        String masGanado = "";
        int mapasCreados = 0;

        System.out.println("*Estadísticas Generales*");
        System.out.println("Cantidad de veces atrapado: " + vecesAtrapado);
        System.out.println("Cantidad de partidas ganadas: " + partidasGanadas);
        System.out.println("Oro promedio por partida: " + promedioOro);
        System.out.println("Promedio de movimientos: " + promedioMovimiento);
        System.out.println("Mapa más jugado: " + mapaMasJugado);
        System.out.println("Mapa más perdido: " + masPerdido);
        System.out.println("Mapa más ganado: " + masGanado);
        System.out.println("Total de mapas creados: " + mapasCreados);
    }

}
