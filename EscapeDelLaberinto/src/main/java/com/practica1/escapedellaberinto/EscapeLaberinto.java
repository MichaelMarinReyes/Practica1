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
                    tamañoMapa();
                    diseñoMapa();
                    mostrarMapa();
                    menuPrincipal();
                    break;

                case 3:
                    System.out.println("**********************");
                    reporteGeneral();
                    menuPrincipal();
                    break;

                case 4:
                    System.out.println("**********************");
                    mapasAlmacenados();
                    menuPrincipal();
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

        System.out.println("Elejir un mapa");
        mostrarMapa();
        comandos();
        reportesFinales();

        System.out.println("1. Regresar al Menu Principal");
        subMenu = entrada.nextInt();

        if (subMenu == 1) {
            menuPrincipal();

        }
    }

    public static void creacionMapas() {
        int eleccion;

        System.out.println("Presione 1 si desea crear un mapa nuevo");
        System.out.println("Presione 2 si desea regresar al Menu Principal");
        eleccion = entrada.nextInt();

        if (eleccion == 1) {
            tamañoMapa();

        } else {
            System.out.println("Regresando al Menú Principal ... ...");
            menuPrincipal();
        }

    }

    public static void juego() {
        reportesFinales();

    }

    public static void mapasAlmacenados() {
        int indice = 0;
        int regresar;
        String nombreMapa[] = new String[indice];
        int mapaCreado[] = new int[indice];

        indice += 1;

        System.out.println("Regresar al Menú Principal: 1");
        regresar = entrada.nextInt();

        if (regresar == 1) {
            menuPrincipal();
        } else {
            mapasAlmacenados();
        }
    }

    public static String mapas[][][] = new String[30][][];

    public static void tamañoMapa() {
        int numeroFilas;
        int numeroColumnas;
        String nombreMapa;
        int catidadMapa = 1;

        System.out.print("Escriba un nombre con el que desea guardar el mapa: ");
        nombreMapa = entrada.next();

        System.out.println("Defina el tamaño del laberinto que desea ingresando los siguientes datos:");
        System.out.print("Número de filas: ");
        numeroFilas = entrada.nextInt();
        System.out.print("Número de columnas: ");
        numeroColumnas = entrada.nextInt();
        System.out.println("");
        mapas[catidadMapa] = new String[numeroFilas][numeroColumnas];

    }

    public static void diseñoMapa() {
        String jugador = "J";
        String bot = "B";
        String casilla = "O";
        String oro = "G";
        String salida = "S";
        String pared = "#";
        String caracter;
        int salidas = 0;
        int tipo;

        for (int i = 0; i < mapas.length; i++) {
            System.out.println("Fila: " + i);
            System.out.println("Para crear el mapa de juego indice:\n1.Número de casillas vacias\n2.Oro\n3.Salida\n3.Pared");
            tipo = entrada.nextInt();

            if (tipo == 1) {
                caracter = casilla;
            } else if (tipo == 2) {
                caracter = oro;
            } else if (tipo == 3) {
                caracter = salida;
            } else {
                caracter = pared;
            }

            for (int j = 0; j < mapas[i].length; j++) {
                for (int k = 0; k < mapas.length; k++) {
                    mapas[i][j][k] = caracter;

                }
            }
        }
    }

    public static void mostrarMapa() {
        for (int i = 0; i < mapas.length; i++) {
            for (int j = 0; j < mapas[i].length; j++) {
                for (int k = 0; k < mapas.length; k++) {
                    System.out.println(mapas[i][j][k]);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public static void comandos() {
        String comando;
        String inexistente;

        //      do {
        System.out.println("Ingrese uno de los siguientes comandos\nPuede escribir algunos de los siguientes comandos en mayúscula y minúscula");
        System.out.println("ORO_REQUERIDO = Muestra cantidad de oro que se necesita para las salidas del laberinto");
        System.out.println("ORO = Muestra la cantidad de oro que posee");
        System.out.println("MOVER = Para avanzar posiciónes");
        System.out.println("LEVANTAR = Para levantar el oro encontrado");
        System.out.println("MIRAR = Muestra la posición del Jugador y los caminos que podría seguir");
        System.out.println("SALIR = Al llegar a una de las salidas puede ingresar el comando y terminar el juego");
        comando = entrada.next();

        if (comando.equals("ORO_REQUERIDO") || comando.equals("oro_requerido")) {
            oroRequerido();

        } else if (comando.equals("ORO") || comando.equals("oro")) {

        } else if (comando.equals("MOVER") || comando.equals("mover")) {
            movimiento();

        } else if (comando.equals("LEVANTAR") || comando.equals("levantar")) {

        } else if (comando.equals("MIRAR") || comando.equals("mirar")) {

        } else if (comando.equals("SALIR") || comando.equals("salir")) {

        } else {
            System.out.println("Comando ingresado inexistente, vuelva a intentarlo");

        }

        //     } while (comando = );
    }

    public static void oroRequerido() {
        int cantidadOro;
        int oro = 0;

        System.out.println("Oro actual: " + oro);
    }

    public static void movimiento() {
        String direccion;

        System.out.println("Para moverse a alguna dirección debe escribir alguno de los siguentes comandos");
        System.out.println("Para moverse una casilla hacia arriba puede escribir MOVER A ó mover a");
        System.out.println("Para moverse una casilla hacia abajo puede escribir MOVER S ó mover s");
        System.out.println("Para moverse una casilla hacia la derecha puede escribir MOVER E ó mover e");
        System.out.println("Para moverse una casilla hacia la izquierda puede escribir MOVER O u mover o");
        direccion = entrada.next();

        if (direccion.equals("MOVER A") || direccion.equals("mover a")) {
            //mover arriba
            System.out.println("J ha sido desplazado una posición arriba");

        } else if (direccion.equals("MOVER S") || direccion.equals("mover s")) {
            //mover abajo
            System.out.println("J ha sido desplazado una posición abajo");

        } else if (direccion.equals("MOVER E") || direccion.equals("mover e")) {
            //mover derecha
            System.out.println("J ha sido desplazado una posición a la derecha");

        } else if (direccion.equals("MOVER O") || direccion.equals("mover o")) {
            //mover izquierda
            System.out.println("J ha sido desplazado una posición a la izquierda");

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
