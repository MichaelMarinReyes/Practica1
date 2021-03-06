package com.practica1.escapedellaberinto;

import java.util.Scanner;

/**
 *
 * @author michael
 */
public class EscapeLaberinto {

    public static int cantidadMapas = 20;
    public static String mapas[][];
    public static String[] nombres;
    public static String[][][] mapasGuardados;
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("**************************");
        System.out.println("*ESCAPE DEL LABERINTO*");
        System.out.println("**************************");

        menuPrincipal();

    }

    public static void menuPrincipal() {
        int opcion;

        System.out.println("\n-Menú Principal-");
        System.out.println("1. Jugar\n2. Crear Mapa\n3. Reportes\n4. Visualizar Mapas\n5. Salir");
        opcion = entrada.nextInt();

        if (opcion <= 5) {
            switch (opcion) {
                case 1:
                    System.out.println("**********************");
                    jugar();
                    break;

                case 2:
                    int retorno;
                    System.out.println("**********************");
                    tamañoMapa();
                    diseñoMapa();
                    mostrarMapaCreado();

                    System.out.println("Para regresar al Menú Principal presione 1");
                    retorno = entrada.nextInt();

                    if (retorno == 1) {
                        menuPrincipal();
                    }
                    break;

                case 3:
                    System.out.println("**********************");
                    reporteGeneral();
                    menuPrincipal();
                    break;

                case 4:
                    System.out.println("**********************");
                    mostrarListadoMapas();
                    menuPrincipal();
                    break;

                case 5:
                    System.out.println("**********************");
                    System.out.println("-Saliendo del Juego-");
                    break;

                default:
                    System.out.println("Número de opcion ingresado invalido\nIntente nuevamente");
                    menuPrincipal();
                    break;
            }

        } else {
            while (opcion > 5) {
                menuPrincipal();
            }
        }

    }

    public static void jugar() {
        int subMenu;
        char jugador = 'J';
        char bot = 'B';
        char vacio = 'O';
        char oro = 'G';
        char salida = 'S';

        System.out.println("Elejir un mapa");
        mapaPrincipal();
        mostrarMapaCreado();
        partida();

        System.out.println("1. Regresar al Menu Principal");
        subMenu = entrada.nextInt();

        if (subMenu == 1) {
            menuPrincipal();

        }
    }

    public static void partida() {
        int posicionJugador;
        int posicionBot;
        int posicionOro;
        int turnoBot;

        System.out.println("Turno: Jugador");
        comandos();

        System.out.println("Turno Bot");
        bot();

        reportesFinales();

    }

    public static void bot() {
        int posicionBot;
        int atrapado = 0;
        int visto = 0;

    }

    public static void posicionJugador() {

    }

    public static void mapaPrincipal() {
        int indice = 0;
        String mapas[][] = {{" # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " S", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # "},
        {" S", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " S"},
        {" # ", " # ", " # ", " # ", " # ", " # ", " O ", " O ", " # ", " # ", " # ", " O ", " # ", " # ", " # ", " O ", " # ", " O ", " O ", " # ", " # ", " # ", " # ", " # ", " # ", " O ", " O ", " # ", " O ", " # "},
        {" # ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " # ", " # ", " O ", " O ", " O ", " # "},
        {" # ", " O ", " # ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " # ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " O ", " # ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " O ", " O ", " # ", " # ", " # "},
        {" # ", " # ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " O ", " # ", " # ", " O ", " # ", " # ", " O ", " # ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " # ", " # ", " O ", " # "},
        {" # ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " # ", " O ", " # "},
        {" # ", " O ", " # ", " # ", " O ", " # ", " # ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " # ", " O ", " # ", " O ", " # ", " # ", " # ", " O ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " O ", " # ", " O ", " O ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " # ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " # ", " O ", " # ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " # ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " O ", " O ", " # ", " O ", " O ", " # ", " # ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " # ", " O ", " # ", " # ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " # ", " O ", " # ", " # ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " O ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " # ", " O ", " O ", " # ", " O ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " # ", " O ", " # ", " # ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " # ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " # ", " # ", " # ", " # ", " O ", " # "},
        {" # ", " O ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " # ", " O ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " # ", " O ", " O ", " O ", " # ", " # ", " # ", " O ", " # ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " # ", " O ", " # "},
        {" # ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " O ", " O ", " O ", " O ", " # "},
        {" # ", " O ", " # ", " O ", " O ", " O ", " # ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " O ", " # ", " # ", " # ", " # ", " # ", " O ", " O ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " O ", " O ", " # ", " O ", " # ", " # ", " # "},
        {" # ", " O ", " # ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " S"},
        {" # ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " # ", " # ", " # ", " # ", " # ", " O ", " # ", " # ", " # ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " # ", " # "},
        {" # ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " # ", " O ", " O ", " # ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " O ", " # ", " O ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " # "},
        {" # ", " O ", " # ", " O ", " O ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " # ", " # ", " # ", " O ", " # ", " # ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " O ", " # "},
        {" # ", " O ", " # ", " # ", " # ", " O ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " # ", " # ", " # ", " O ", " # ", " O ", " # ", " # ", " O ", " # "},
        {" # ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " # ", " O ", " O ", " # "},
        {" # ", " O ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " O ", " # ", " O ", " # ", " # ", " # ", " O ", " # ", " O ", " # ", " # ", " # ", " # ", " # ", " O ", " O ", " O ", " # ", " # "},
        {" # ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " O ", " # ", " O ", " O ", " # "},
        {" # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " S", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # ", " # "}};

        guardarMapa(indice, mapas, "Mapa Principal");
    }

    public static void tamañoMapa() {
        int filas;
        int columnas;
        int indice = 1;

        System.out.println("Número de mapa: " + (indice + 1));
        System.out.println("Para definir el tamaño del mapa ingrese los siguientes datos");
        System.out.print("Número de filas: ");
        filas = entrada.nextInt();
        System.out.print("Número de columnas: ");
        columnas = entrada.nextInt();
        mapas = new String[filas][columnas];
        indice++;
    }

    public static void diseñoMapa() {
        String casilla = " O ";
        String salida = " S";
        final String PARED = " # ";
        int tipo;
        String nombre;
        int indice = 1;
        int dinero = 0;

        System.out.print("Escriba un nombre con el que desea guardar el mapa: ");
        nombre = entrada.next();
        for (int i = 0; i < mapas.length; i++) {
            for (int j = 0; j < mapas.length; j++) {
                System.out.println("Puede usar los siguientes elementos para crear el mapa");
                System.out.println("1. Pared \"#\"\n2. Casilla vacia \"O\"\n3. Salida \"S\"\n");
                System.out.print("Casilla: |" + (i + 1) + "||" + (j + 1) + "| \n");
                tipo = entrada.nextInt();

                if (tipo == 1) {
                    mapas[i][j] = PARED;
                } else if (tipo == 2) {
                    mapas[i][j] = casilla;
                } else if (tipo == 3) {
                    System.out.println("¿Cuanto será el dinero requerido para utilizar esta salida?");
                    dinero = entrada.nextInt();
                    mapas[i][j] = salida + dinero;
                }
            }
        }
        System.out.println("**MAPA CREADO**");
        System.out.println(nombre);

        guardarMapa(indice, mapas, nombre);
        indice++;
    }

    public static void mostrarMapaCreado() {

        for (int i = 0; i < mapas.length; i++) {
            for (int j = 0; j < mapas.length; j++) {
                System.out.print(mapas[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void guardarMapa(int posicion, String[][] mapaCreado, String nombre) {
        int indice = 1;
        nombres = new String[cantidadMapas];
        mapasGuardados = new String[cantidadMapas][][];

        nombres[indice] = nombre;
        mapasGuardados[indice] = mapas;
        indice++;
    }

    public static void mostrarListadoMapas() {
        for (int i = 0; i < mapas.length; i++) {
            System.out.println("Mapa número: " + (i + 1) + "\tNombre: " + nombres[i]);
            for (int j = 0; j < mapas[i].length; j++) {
                for (int k = 0; k < mapas[j].length; k++) {
                    System.out.print(mapas[i].length);
                }
                System.out.println("");
            }
            System.out.println("");

        }
        System.out.println("\n");
    }

    public static void comandos() {
        String comando;
        String inexistente;

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
            for (int i = 0; i < mapas.length; i++) {
                for (int j = 0; j < mapas.length; j++) {
                    System.out.print(mapas[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");

        } else if (comando.equals("SALIR") || comando.equals("salir")) {

        } else {
            System.out.println("Comando ingresado inexistente, vuelva a intentarlo");
        }
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
