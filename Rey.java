import java.util.Scanner;

public class Rey {
    static Tablero tb = new Tablero();
    public static String mostrarPosicion(String[][] tablero) {
        // Muestra la posicion de la pieza en el tablero.
        String reyBlanco = "\uD83D\uDC51";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[j][i] == reyBlanco) {
                    return "La posicion es " + columna(j + 1) + (i + 1);
                }
            }
        }
        return "Error";
    }
    public static int scanner() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() - 1;
    }
    public static String movimiento (int coordenada, int letra, int numero, String[][] tablero) {
        /*
        | 1 2 3 |
        | 4 X 6 |
        | 7 8 9 |
        X es la posicion del rey y los numero los posibles movimientos
         */
        String verde = "🟩";
        int letraTablero = letra - 1;
        int numeroTablero = numero - 1;
        switch (coordenada) {
            case 1:
                tablero[letraTablero - 1][numeroTablero + 1] = verde; // Cambia la coordenada en la que se puede mover por un cuadrado verde
                tb.setTablero(tablero); // Modifica el objeto tablero
                return columna(letra - 1) + "" + (numero + 1) + ", "; // Devuelve el String con texto de la posicion a la que puede moverse.
            case 2:
                tablero[letraTablero][numeroTablero + 1] = verde;
                tb.setTablero(tablero);
                return columna(letra) + "" + (numero + 1) + ", ";
            case 3:
                tablero[letraTablero + 1][numeroTablero + 1] = verde;
                tb.setTablero(tablero);
                return columna(letra + 1) + "" + (numero + 1) + ", ";
            case 4:
                tablero[letraTablero - 1][numeroTablero] = verde;
                tb.setTablero(tablero);
                return columna(letra - 1) + "" + numero + ", ";
            case 6:
                tablero[letraTablero + 1][numeroTablero] = verde;
                tb.setTablero(tablero);
                return columna(letra + 1) + "" + numero + ", ";
            case 7:
                tablero[letraTablero - 1][numeroTablero - 1] = verde;
                tb.setTablero(tablero);
                return columna(letra - 1) + "" + (numero - 1) + ", ";
            case 8:
                tablero[letraTablero][numeroTablero - 1] = verde;
                tb.setTablero(tablero);
                return columna(letra) + "" + (numero - 1) + ", ";
            case 9:
                tablero[letraTablero + 1][numeroTablero - 1] = verde;
                tb.setTablero(tablero);
                return columna(letra + 1) + "" + (numero - 1);
            default:
                return "Error";
        }
    }
    public static char columna(int i) {
        // Define la posicion con letra depende de la coordenada que le pasen.
        return switch (i) {
            case 1 -> 'a';
            case 2 -> 'b';
            case 3 -> 'c';
            case 4 -> 'd';
            case 5 -> 'e';
            case 6 -> 'f';
            case 7 -> 'g';
            case 8 -> 'h';
            default -> 'x';
        };
    }
    public static String Rey(String[][] tablero, int letra, int numero) {
        numero -= 1;
        tablero[letra][numero] = "👑";

        String movimientos = "Posibles movimientos: ";
        letra += 1;
        numero += 1;
        if (letra != 1 && numero != 1 && letra != 8 && numero != 8) {

            // Posibles Movimientos del rey dentro de los bordes del tablero
            movimientos += movimiento(1, letra, numero, tablero) + movimiento(2, letra, numero, tablero) + movimiento(3, letra, numero, tablero) + movimiento(4, letra, numero, tablero) + movimiento(6, letra, numero, tablero) + movimiento(7, letra, numero, tablero) + movimiento(8, letra, numero, tablero) + movimiento(9, letra, numero, tablero);

        } else if (letra == 1 && numero == 1){

            // Posibles Movimientos del rey en la esquina inferior izquierda
            movimientos += movimiento(2, letra, numero, tablero) + movimiento(3, letra, numero, tablero) + movimiento(6, letra, numero, tablero);

        } else if (letra == 1 && numero == 8) {

            // Posibles Movimientos del rey en la esquina superior izquierda
            movimientos += movimiento(6, letra, numero, tablero) + movimiento(8, letra, numero, tablero) + movimiento(9, letra, numero, tablero);

        } else if (letra == 8 && numero == 8) {

            // Posibles Movimientos del rey en la esquina superior derecha
            movimientos += movimiento(4, letra, numero, tablero) + movimiento(7, letra, numero, tablero) + movimiento(8, letra, numero, tablero);

        } else if (letra == 8 && numero == 1) {

            // Posibles Movimientos del rey en la esquina inferior derecha
            movimientos += movimiento(1, letra, numero, tablero) + movimiento(2, letra, numero, tablero) + movimiento(4, letra, numero, tablero);

        } else if (numero == 1) {

            // Posibles Movimientos del rey en el borde inferior (sin esquinas)
            movimientos += movimiento(1, letra, numero, tablero) + movimiento(2, letra, numero, tablero) + movimiento(3, letra, numero, tablero) + movimiento(4, letra, numero, tablero) + movimiento(6, letra, numero, tablero);

        } else if (letra == 1) {

            // Posibles Movimientos del rey en el borde izquierdo (sin esquinas)
            movimientos += movimiento(2, letra, numero, tablero) + movimiento(3, letra, numero, tablero) + movimiento(6, letra, numero, tablero) + movimiento(8, letra, numero, tablero) + movimiento(9, letra,numero, tablero);

        } else if (numero == 8) {

            // Posibles Movimientos del rey en el borde superior (sin esquinas)
            movimientos += movimiento(4, letra, numero, tablero) + movimiento(6, letra, numero, tablero) + movimiento(7, letra, numero, tablero) + movimiento(8, letra, numero, tablero) + movimiento(9, letra, numero, tablero);

        } else {

            // Posibles Movimientos del rey en el borde superior (sin esquinas)
            movimientos += movimiento(1, letra, numero, tablero) + movimiento(2, letra, numero, tablero) + movimiento(4, letra, numero, tablero) + movimiento(7, letra, numero, tablero) + movimiento(8, letra, numero, tablero);
        }

        return movimientos; // Movimientos que puede hacer.
    }
}