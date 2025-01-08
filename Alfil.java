public class Alfil {
    public static void PiezaAlfil(String letraString,int numero){
        Tablero tb=new Tablero();
        String[][]tablero;
        int letra=Tablero.LetraToNumero(letraString);
        tablero=tb.InicializarTablero();
        String movimientos=(MovimientosAlfil.PosicionesAlfil(tablero,letra,numero));
        tb.getTablero();
        System.out.println(movimientos);


    }
}