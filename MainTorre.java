import java.util.Scanner;

public class MainTorre {
    public static void main(String[] args) {
        Tablero tb = new Tablero();
        String[][] tablero;

        Scanner sc = new Scanner(System.in);
        System.out.print("Letra: ");
        String letraString = sc.nextLine(); // Esto es la coordenada de las letras
        System.out.print("Número: ");
        int numero = sc.nextInt(); // Esto es la coordenada de los números

        // La letra que introduces es visual y hay que convertirla en número
        int letra = Tablero.LetraToNumero(letraString);

        Torre torre = new Torre();

        tablero = tb.InicializarTablero(); // Inicializa el tablero en blanco y negro

        String movimientos = Torre.PosicionesTorre(tablero, letra, numero); // Calcula los posibles movimientos

        tb.getTablero(); // Imprime el tablero modificado
        System.out.println(movimientos); // Imprime los posibles movimientos
    }
}