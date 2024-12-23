import java.util.Scanner;

public class MainAlfil {
    public static void main(String[] args) {
        Tablero tb=new Tablero();
        String[][] tablero;
        Scanner sc=new Scanner(System.in);
        System.out.print("Letra:");
        String letraString= sc.nextLine().toLowerCase();
        System.out.print("Numero:");
        int numero= sc.nextInt();
        int letra=Tablero.LetraToNumero(letraString);
        Alfil Piezaalfil=new Alfil();

        tablero=tb.InicializarTablero();

        String movimientos=(Piezaalfil.PosicionesAlfil(tablero,letra,numero));
        tb.getTablero();
        System.out.println(movimientos);
    }
}
