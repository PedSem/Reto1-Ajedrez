public class MovimientosPeon {
    static Tablero tb = new Tablero();
    public static String movimiento (int opcion, int letra, int numero, String[][] tablero) {
        /*
        |    2 |
        | 1  2 |
        | x  X |
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
            default:
                return "Error";
        }
    }
    public static String Peon(String[][] tablero, int letra, int numero) {
        numero -= 1;
        tablero[letra][numero] = "\u001B[1;30m\u001B[43m P \u001B[0m"; // define posicion de la pieza

        String movimientos = "Posibles movimientos: ";
        letra += 1;
        numero += 1;

        if (numero == 1 || numero == 8) {
            return "Error, un peón nunca puede situarse en la fila 1 u 8";
        } else if (numero == 2) {
            movimientos += movimiento(2, letra, numero, tablero);
        } else {
            movimientos += movimiento(1, letra, numero, tablero);
        }

        return movimientos; // Movimientos que puede hacer.
    }
}
