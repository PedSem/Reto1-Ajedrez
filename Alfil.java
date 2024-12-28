public class Alfil {
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
