import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tablero tb = new Tablero();
        String[][] tablero;

        Scanner sc = new Scanner(System.in);
        System.out.print("Letra: ");
        String letraString = sc.nextLine(); // Esto es la coordenada de las letras
        System.out.print("Número: ");
        int numero = sc.nextInt(); // Esto es la coordenada de los numero

        // La letra que introduces es visual y hay que volver a ponerla como numero.
        int letra = Tablero.LetraToNumero(letraString);

        Rey rey = new Rey();

        tablero = tb.InicializarTablero(); // Inicializa tablero en negro y blanco

        String movimientos = (rey.Rey(tablero, letra, numero)); // Guarda los posibles movimientos en un String para mostrarlos después

        tb.getTablero(); // Imprime el tablero modificado
        System.out.println(movimientos); // Imprime los posibles movimientos
    }
}
