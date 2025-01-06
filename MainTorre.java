import java.util.Scanner;

public class MainTorre {
    public static void main(String[] args) {
        Tablero tb = new Tablero();
        String[][] tablero;

        Scanner sc = new Scanner(System.in);
        System.out.print("Letra: ");
        String letraString = sc.nextLine(); // Coordenada de las letras
        System.out.print("Número: ");
        int numero = sc.nextInt(); // Coordenada de los números

        // La letra que introduces es visual y hay que convertirla en número
        int letra = Tablero.LetraToNumero(letraString);

        Torre torre = new Torre();

        tablero = tb.InicializarTablero(); // Inicializa el tablero

        String movimientos = Torre.PosicionesTorre(tablero, letra, numero); // Calcula los posibles movimientos

        tb.getTablero(); // Imprime el tablero ya modificado
        System.out.println(movimientos); // Imprime los posibles movimientos
    }
}