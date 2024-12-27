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
        numero -= 1;
        tablero[letra][numero] = "\u001B[1;30m\u001B[43m P \u001B[0m"; // define posicion de la pieza

        String movimientos = "Posibles movimientos: ";
        letra += 1;
        numero += 1;

        if (numero == 1 || numero == 8) {
            return "Error, un peón nunca puede situarse ni mover en la fila 1 u 8";
        } else if (color.equals("B")) {
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
