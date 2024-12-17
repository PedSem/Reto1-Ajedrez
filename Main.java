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
        int letra = switch (letraString) {
            case "a" -> 1;
            case "b" -> 2;
            case "c" -> 3;
            case "d" -> 4;
            case "e" -> 5;
            case "f" -> 6;
            case "g" -> 7;
            case "h" -> 8;
            default -> 0;
        } - 1; // Como el array cuenta desde 0 es necesario restarle 1

        Rey rey = new Rey();

        tablero = tb.InicializarTablero(); // Inicializa tablero en negro y blanco

        String movimientos = (rey.Rey(tablero, letra, numero)); // Guarda los posibles movimientos en un String para mostrarlos después
        System.out.println(rey.mostrarPosicion(tablero)); // Muestra la posicion en la que esta

        tb.getTablero(); // Imprime el tablero modificado
        System.out.println(movimientos); // Imprime los posibles movimientos
    }
}
