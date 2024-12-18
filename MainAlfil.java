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
        int letra=switch (letraString){
            case "a" -> 1;
            case "b" -> 2;
            case "c" -> 3;
            case "d" -> 4;
            case "e" -> 5;
            case "f" -> 6;
            case "g" -> 7;
            case "h" -> 8;
            default -> 0;
        } -1;
        Alfil Piezaalfil=new Alfil();

        tablero=tb.InicializarTablero();

        String movimientos=(Piezaalfil.PosicionesAlfil(tablero,letra,numero));
        System.out.println(Piezaalfil.mostrarPosicionAlfil(tablero));
        tb.getTablero();
        System.out.println(movimientos);
    }
}
