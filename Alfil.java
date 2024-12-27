
import java.util.Scanner;

public class Alfil {
    /*
    public static void main(String[] args) {
        Tablero tb=new Tablero();
        String[][] tablero;
        Scanner sc=new Scanner(System.in);
        System.out.print("Letra:");
        String letraString= sc.nextLine().toLowerCase();
        System.out.print("Numero:");
        int numero= sc.nextInt();
        int letra=Tablero.LetraToNumero(letraString);
        MovimientosAlfil Piezaalfil=new MovimientosAlfil();
        tablero=tb.InicializarTablero();

        String movimientos=(Piezaalfil.PosicionesAlfil(tablero,letra,numero));
        tb.getTablero();
        System.out.println(movimientos);
    }

     */
    public static void Alfil(String letraString,int numero,String color){
        Tablero tb=new Tablero();
        String[][]tablero;
        int letra=Tablero.LetraToNumero(letraString);
        tablero=tb.InicializarTablero();
        String movimientos=(MovimientosAlfil.PosicionesAlfil(tablero,letra,numero,color));
        tb.getTablero();
        System.out.println(movimientos);


    }
}
