import java.util.Scanner;

public class MovimientosPeon {
    static Tablero tb = new Tablero();
    public static String movimiento (int opcion, int letra, int numero, String[][] tablero) {
        /*
        |    2     X  X |
        | 1  2     3  4 |
        | X  X        4 |
        X es la posicion del rey y los numeros de los posibles movimientos
         */
        String verde = "\u001B[1m\u001B[42m · \u001B[0m";
        int letraTablero = letra - 1;
        int numeroTablero = numero - 1;
        switch (opcion) {
            case 1:
                tablero[letraTablero][numeroTablero + 1] = verde; // Cambia la opcion en la que se puede mover por un cuadrado verde
                tb.setTablero(tablero); // Modifica el objeto tablero
                return Tablero.NumeroToLetra(letra) + "" + (numero + 1); // Devuelve el String con texto de la posicion a la que puede moverse.
            case 2:
                String coordenadasMovimientosFinales = "";
                for (int i = 1; i <= 2; i++) {
                    tablero[letraTablero][numeroTablero + i] = verde;
                    coordenadasMovimientosFinales = Tablero.NumeroToLetra(letra) + "" + (numero + i) + ", ";
                }
                tb.setTablero(tablero);
                return coordenadasMovimientosFinales;
            case 3:
                tablero[letraTablero][numeroTablero - 1] = verde; // Cambia la opcion en la que se puede mover por un cuadrado verde
                tb.setTablero(tablero); // Modifica el objeto tablero
                return Tablero.NumeroToLetra(letra) + "" + (numero + 1); // Devuelve el String con texto de la posicion a la que puede moverse.
            case 4:
                coordenadasMovimientosFinales = "";
                for (int i = 1; i <= 2; i++) {
                    tablero[letraTablero][numeroTablero - i] = verde;
                    coordenadasMovimientosFinales = Tablero.NumeroToLetra(letra) + "" + (numero + i) + ", ";
                }
                tb.setTablero(tablero);
                return coordenadasMovimientosFinales;
            default:
                return "Error";
        }
    }
    public static String Peon(String[][] tablero, int letra, int numero, String color) {
        Scanner sc = new Scanner(System.in);
        numero -= 1;

        if ((color.equals("B") && numero == 7) || (color.equals("N") && numero == 0)) {
            System.out.println("""
                ====================================
                Has llegado al final del tablero.
                (D)ama
                (T)orre
                (A)lfil
                (C)aballo""");
            System.out.print("¿En qué pieza te conviertes? ");
            String pieza = sc.nextLine().toUpperCase(); // Pone minúsculas en mayúsculas
            System.out.println("===================================="); // Para dejar espacio con la respuesta

            while (!(pieza.equals("D") || pieza.equals("T") || pieza.equals("A") || pieza.equals("C"))) {
                System.out.println("No existe esa pieza. Por favor, elige una válida y asegurate de solo poner la inicial");
                System.out.println("""
                (D)ama
                (T)orre
                (A)lfil
                (C)aballo""");
                System.out.print("En que pieza te conviertes? ");
                pieza = sc.nextLine().toUpperCase(); // Reiniciar la selección
            }

            switch (pieza) {
                    case "D":
                        System.out.println("Has escogido la Dama.");
                        System.out.println();
                        tablero[letra][numero] = "\u001B[1;30m\u001B[43m D \u001B[0m";
                        Dama.PiezaDama(Tablero.NumeroToLetraString(letra + 1), numero + 1); // define posicion de la pieza
                        break;
                    case "T":
                        System.out.println("Has escogido la Torre.");
                        System.out.println();
                        tablero[letra][numero] = "\u001B[1;30m\u001B[43m T \u001B[0m"; // define posicion de la pieza
                        Torre.PiezaTorre(Tablero.NumeroToLetraString(letra + 1), numero + 1);
                        break;
                    case "A":
                        System.out.println("Has escogido el Alfil");
                        System.out.println();
                        tablero[letra][numero] = "\u001B[1;30m\u001B[43m A \u001B[0m"; // define posicion de la pieza
                        Alfil.PiezaAlfil(Tablero.NumeroToLetraString(letra + 1), numero + 1);
                        break;
                    case "C":
                        System.out.println("Has escogido el Caballo.");
                        System.out.println();
                        tablero[letra][numero] = "\u001B[1;30m\u001B[43m C \u001B[0m"; // define posicion de la pieza
                        Caballo.PiezaCaballo(Tablero.NumeroToLetraString(letra + 1), numero + 1);
                        break;
            }

        } else tablero[letra][numero] = "\u001B[1;30m\u001B[43m P \u001B[0m"; // define posicion de la pieza


        String movimientos = "Posibles movimientos: ";
        letra += 1;
        numero += 1;

        if (color.equals("B") && numero == 1) {
            return "Error, un peón blanco situarse en la coordenada con numero 1";
        } else if (color.equals("N") && numero == 8) {
            return "Error, un peón blanco situarse en la coordenada con numero 1";
        } else if (numero == 1 || numero == 8) {
            return "";
        }
        if (color.equals("B")) {
            if (numero == 2) {
                movimientos += movimiento(2, letra, numero, tablero);
            } else {
                movimientos += movimiento(1, letra, numero, tablero);
            }
        } else {
            if (numero == 7) {
                movimientos += movimiento(4, letra, numero, tablero);
            } else {
                movimientos += movimiento(3, letra, numero, tablero);
            }
        }

        return movimientos; // Movimientos que puede hacer.
    }
}
