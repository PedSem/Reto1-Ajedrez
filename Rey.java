import java.util.Scanner;

public class Rey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Letra: ");
        String letraString = sc.next();
        System.out.print("num: ");
        int numero = sc.nextInt();

        Tablero tb = new Tablero();
        String[][] tablero;

        // La letra que introduces es visual y hay que volver a ponerla como numero.
        int letra = Tablero.LetraToNumero(letraString);

        MovimientosRey movimientosRey = new MovimientosRey();

        tablero = tb.InicializarTablero(); // Inicializa tablero en negro y blanco

        String movimientos = (MovimientosRey.Rey(tablero, letra, numero)); // Guarda los posibles movimientos en un String para mostrarlos después

        tb.getTablero(); // Imprime el tablero modificado
        System.out.println(movimientos); // Imprime los posibles movimientos
    }
}
