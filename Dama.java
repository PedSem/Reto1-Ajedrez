import java.util.Scanner;

public class Dama {
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


        tablero = tb.InicializarTablero();
        String movimientos = (MovimientosDama.DamaOpciones(tablero,letra,numero));
        tb.getTablero();
        System.out.println(movimientos);
    }
}
