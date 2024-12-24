public class MovimientosRey {
    static Tablero tb = new Tablero();
    public static String movimiento (int coordenada, int letra, int numero, String[][] tablero) {
        /*
        | 1 2 3 |
        | 4 X 6 |
        | 7 8 9 |
        X es la posicion del rey y los numero los posibles movimientos
         */
        String verde = "\u001B[1m\u001B[42m · \u001B[0m";
        int letraTablero = letra - 1;
        int numeroTablero = numero - 1;
        switch (coordenada) {
            case 1:
                tablero[letraTablero - 1][numeroTablero + 1] = verde; // Cambia la coordenada en la que se puede mover por un cuadrado verde
                tb.setTablero(tablero); // Modifica el objeto tablero
                return Tablero.NumeroToLetra(letra - 1) + "" + (numero + 1) + ", "; // Devuelve el String con texto de la posicion a la que puede moverse.
            case 2:
                tablero[letraTablero][numeroTablero + 1] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra) + "" + (numero + 1) + ", ";
            case 3:
                tablero[letraTablero + 1][numeroTablero + 1] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra + 1) + "" + (numero + 1) + ", ";
            case 4:
                tablero[letraTablero - 1][numeroTablero] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra - 1) + "" + numero + ", ";
            case 6:
                tablero[letraTablero + 1][numeroTablero] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra + 1) + "" + numero + ", ";
            case 7:
                tablero[letraTablero - 1][numeroTablero - 1] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra - 1) + "" + (numero - 1) + ", ";
            case 8:
                tablero[letraTablero][numeroTablero - 1] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra) + "" + (numero - 1) + ", ";
            case 9:
                tablero[letraTablero + 1][numeroTablero - 1] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra + 1) + "" + (numero - 1);
            default:
                return "Error";
        }
    }
    public static String Rey(String[][] tablero, int letra, int numero) {
        numero -= 1;
        tablero[letra][numero] = "\u001B[1;30m\u001B[43m R \u001B[0m";

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