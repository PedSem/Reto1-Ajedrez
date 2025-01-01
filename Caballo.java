public class Caballo {
    public static void Caballo(String letraString, int numero) {
        Tablero tb = new Tablero(); // Crear una instancia del tablero
        String[][] tablero;

        // Convertir la letra de la posición (por ejemplo, 'b') a un número para usarlo como índice
        int letra = Tablero.LetraToNumero(letraString);

        // Inicializar el tablero (cuadrícula en blanco y negro)
        tablero = tb.InicializarTablero();

        // Obtener los movimientos posibles del caballo como un String
        String movimientos = MovimientosCaballo.Caballo(tablero, letra, numero);

        tb.getTablero(); // Imprime el tablero actualizado
        System.out.println(movimientos); // Imprime los posibles movimientos del caballo
    }
}

