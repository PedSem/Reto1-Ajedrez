public class Peon {
    public static void Peon(String letraString, int numero, String color) {
        Tablero tb = new Tablero();
        String[][] tablero;

        // La letra que introduces es visual y hay que volver a ponerla como numero.
        int letra = Tablero.LetraToNumero(letraString);

        tablero = tb.InicializarTablero(); // Inicializa tablero en negro y blanco

        String movimientos = (MovimientosPeon.Peon(tablero, letra, numero, color)); // Guarda los posibles movimientos en un String para mostrarlos después

        tb.getTablero(); // Imprime el tablero modificado
        System.out.println(movimientos); // Imprime los posibles movimientos
    }
}
