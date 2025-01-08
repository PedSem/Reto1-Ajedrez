public class Caballo {
    public static void PiezaCaballo(String letraString, int numero) {
        Tablero tb = new Tablero(); // Crear una instancia del tablero
        String[][] tablero;

        // Convertir la letra de la posición  a un número para usarlo como índice
        int letra = Tablero.LetraToNumero(letraString);

        // Inicializar el tablero
        tablero = tb.InicializarTablero();

        // Obtener los movimientos posibles del caballo como un String
        String movimientos = Caballo(tablero, letra, numero);

        tb.getTablero(); // Imprime el tablero actualizado
        System.out.println(movimientos); // Imprime los posibles movimientos del caballo
    }

    static Tablero tb = new Tablero();

    //Metodo que realiza un único movimiento del caballo
    public static String movimiento(int coordenada, int letra, int numero, String[][] tablero) {
        // Representa el color verde para destacar las posiciones válidas.
        String verde = "\u001B[1m\u001B[42m · \u001B[0m";

        // Ajusta las coordenadas al índice de array que es 0.
        int letraTablero = letra - 1;
        int numeroTablero = numero - 1;

        // Determina la acción específica según la coordenada (movimiento del caballo).
        switch (coordenada) {
            case 1: // Dos hacia arriba y uno a la izquierda
                tablero[letraTablero - 2][numeroTablero - 1] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra - 2) + "" + (numero - 1) + ", ";
            case 2: // Uno hacia arriba y dos a la izquierda
                tablero[letraTablero - 1][numeroTablero - 2] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra - 1) + "" + (numero - 2) + ", ";
            case 3: // Uno hacia abajo y dos a la izquierda
                tablero[letraTablero + 1][numeroTablero - 2] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra + 1) + "" + (numero - 2) + ", ";
            case 4: // Dos hacia abajo y uno a la izquierda
                tablero[letraTablero + 2][numeroTablero - 1] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra + 2) + "" + (numero - 1) + ", ";
            case 5: // Dos hacia abajo y uno a la derecha
                tablero[letraTablero + 2][numeroTablero + 1] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra + 2) + "" + (numero + 1) + ", ";
            case 6: // Uno hacia abajo y dos a la derecha
                tablero[letraTablero + 1][numeroTablero + 2] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra + 1) + "" + (numero + 2) + ", ";
            case 7: // Uno hacia arriba y dos a la derecha
                tablero[letraTablero - 1][numeroTablero + 2] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra - 1) + "" + (numero + 2) + ", ";
            case 8: // Dos hacia arriba y uno a la derecha
                tablero[letraTablero - 2][numeroTablero + 1] = verde;
                tb.setTablero(tablero);
                return Tablero.NumeroToLetra(letra - 2) + "" + (numero + 1) + ", ";
            default: // Caso de error (movimiento inválido)
                return "Error";
        }
    }


    //Metodo principal que calcula todos los movimientos posibles del caballo desde su posición actual
    public static String Caballo(String[][] tablero, int letra, int numero) {
        // Ajusta la posición actual del caballo en el tablero (se muestra como "C").
        numero -= 1; // Ajuste al índice de array que es 0.
        tablero[letra][numero] = "\u001B[1;30m\u001B[43m C \u001B[0m";

        // Inicializa el texto que describe los movimientos posibles.
        String movimientos = "Posibles movimientos: ";

        // Ajuste para coordinar con el sistema.
        letra += 1;
        numero += 1;

        // Verifica cada posible movimiento y lo añade a los resultados si es válido.
        if (letra > 2 && numero > 1) movimientos += movimiento(1, letra, numero, tablero); // Movimiento 1
        if (letra > 1 && numero > 2) movimientos += movimiento(2, letra, numero, tablero); // Movimiento 2
        if (letra < 8 && numero > 2) movimientos += movimiento(3, letra, numero, tablero); // Movimiento 3
        if (letra < 7 && numero > 1) movimientos += movimiento(4, letra, numero, tablero); // Movimiento 4
        if (letra < 7 && numero < 8) movimientos += movimiento(5, letra, numero, tablero); // Movimiento 5
        if (letra < 8 && numero < 7) movimientos += movimiento(6, letra, numero, tablero); // Movimiento 6
        if (letra > 1 && numero < 7) movimientos += movimiento(7, letra, numero, tablero); // Movimiento 7
        if (letra > 2 && numero < 8) movimientos += movimiento(8, letra, numero, tablero); // Movimiento 8

        // Devuelve todos los movimientos válidos.
        return movimientos;
    }
}

