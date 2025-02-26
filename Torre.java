public class Torre {

    public static void PiezaTorre(String letraString, int numero) {

        Tablero tb = new Tablero(); // Crear una instancia del tablero
        String[][] tablero;

        // Convertir la letra de la posición  a un número para usarlo como índice
        int letra = Tablero.LetraToNumero(letraString);

        // Inicializar el tablero
        tablero = tb.InicializarTablero();

        // Obtener los movimientos posibles de la torre como un String
        String movimientos = PosicionesTorre(tablero, letra, numero);

        tb.getTablero(); // Imprime el tablero actualizado
        System.out.println(movimientos); // Imprime los posibles movimientos del caballo

    }


    static Tablero tb = new Tablero();


    public static String MovimientosTorre(int letra, int numero, String[][] tablero, int direccionLetra, int direccionNumero) {
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
        tablero[letra][numero] = "\u001B[1;30m\u001B[43m T \u001B[0m";

        String movimientos = "Posibles movimientos: ";
        letra += 1;
        numero += 1;

        // Movimientos en las cuatro direcciones posibles
        movimientos += MovimientosTorre(letra, numero, tablero, 0, 1); // Movimientos hacia arriba
        movimientos += MovimientosTorre(letra, numero, tablero, 0, -1); // Movimientos hacia abajo
        movimientos += MovimientosTorre(letra, numero, tablero, 1, 0); // Movimientos hacia la derecha
        movimientos += MovimientosTorre(letra, numero, tablero, -1, 0); // Movimientos hacia la izquierda

        return Tablero.QuitarComa(movimientos);
    }
}