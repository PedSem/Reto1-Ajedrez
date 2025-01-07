public class Dama {
    public static void PiezaDama (String letraString, int numero) {
        Tablero tb = new Tablero();
        String[][] tablero;

        // La letra que introduces es visual y hay que volver a ponerla como numero.
        int letra = Tablero.LetraToNumero(letraString);


        tablero = tb.InicializarTablero();
        String movimientos = (MovimientosDama.DamaOpciones(tablero,letra,numero));
        tb.getTablero();
        System.out.println(movimientos);
    }
}
