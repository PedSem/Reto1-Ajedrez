import java.util.Scanner;

public class Torre {
    static Tablero tb = new Tablero();
    public static int scanner() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() - 1;
    }

    public static String movimientosTorre(int letra, int numero, String[][] tablero, int direccionLetra, int direccionNumero) {
        String verde = "\u001B[1m\u001B[42m · \u001B[0m";
        String movimientos = "";
        int letraTablero = letra - 1;
        int numeroTablero = numero - 1;

        // Continua avanzando hasta llegar al límite del tablero
        int nuevaFila = letraTablero + direccionLetra;
        int nuevaColumna = numeroTablero + direccionNumero;

        while (nuevaFila >= 0 && nuevaFila < 8 && nuevaColumna >= 0 && nuevaColumna < 8) {
            tablero[nuevaFila][nuevaColumna] = verde;
            movimientos += Tablero.NumeroToLetra(nuevaFila + 1) + "" + (nuevaColumna + 1) + ", ";

            // Avanza a la siguiente posición
            nuevaFila += direccionLetra;
            nuevaColumna += direccionNumero;
        }

        tb.setTablero(tablero);
        return movimientos;
    }
    public static String PosicionesTorre(String[][] tablero, int letra, int numero) {
        numero -= 1;
        tablero[letra][numero] = "♖";

        String movimientos = "Posibles movimientos: ";
        letra += 1;
        numero += 1;

        // Movimientos en las cuatro direcciones posibles
        movimientos += movimientosTorre(letra, numero, tablero, 0, 1); // Movimientos hacia arriba
        movimientos += movimientosTorre(letra, numero, tablero, 0, -1); // Movimientos hacia abajo
        movimientos += movimientosTorre(letra, numero, tablero, 1, 0); // Movimientos hacia la derecha
        movimientos += movimientosTorre(letra, numero, tablero, -1, 0); // Movimientos hacia la izquierda

        return movimientos;
    }
}
