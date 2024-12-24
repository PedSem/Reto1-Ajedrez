public class MovimientosDama {
    static Tablero tb = new Tablero();
    public static String movimiento (int cordenada, int letra, int numero, String[][] tablero){
        String verde = "\u001B[1m\u001B[42m · \u001B[0m";
        int letraTablero = letra - 1;
        int numeroTablero = numero - 1;
        int delanteLetra = letraTablero;
        int delanteNumero = numeroTablero;

        switch (cordenada){
            case 1:
                int LETRA = letraTablero;
                int NUMERO = numeroTablero;

                for (int Atras = NUMERO -1 ; Atras >= 0;Atras--) {
                    tablero[LETRA][Atras] = verde;
                    tb.setTablero(tablero);
                }
                for ( int Arriba = NUMERO  + 1; Arriba < tablero.length;Arriba++){
                    tablero[LETRA][Arriba] = verde;
                    tb.setTablero(tablero);
                }
                for (int Derecha = LETRA + 1; Derecha <= tablero.length -1 ; Derecha++){
                    tablero[Derecha][NUMERO] = verde;
                    tb.setTablero(tablero);
                }
                for (int Izquierda = LETRA - 1; Izquierda >= 0; Izquierda--){
                    tablero[Izquierda][NUMERO] = verde;
                    tb.setTablero(tablero);
                }
                //Delante derecha
                do {
                    int i = delanteLetra;
                    int j = delanteNumero;
                    delanteLetra++;
                    delanteNumero++;
                    i++;
                    j++;
                    tablero[i][j] = verde;
                    tb.setTablero(tablero);
                } while (delanteLetra < tablero.length-1 && delanteNumero < tablero.length-1);
                delanteLetra = letraTablero;
                delanteNumero = numeroTablero;

                //Delante izquierda
                do {
                    int i = delanteLetra;
                    int j = delanteNumero;
                    delanteLetra--;
                    delanteNumero++;
                    i--;
                    j++;
                    tablero[i][j] = verde;
                    tb.setTablero(tablero);
                } while (delanteLetra > 0 && delanteNumero < tablero.length - 1);
                delanteLetra = letraTablero;
                delanteNumero = numeroTablero;

                //Detras izquierda
                do {
                    int i = delanteLetra;
                    int j = delanteNumero;
                    delanteLetra--;
                    delanteNumero--;
                    i--;
                    j--;
                    tablero[i][j] = verde;
                    tb.setTablero(tablero);
                }while (delanteLetra > 0 && delanteNumero > 0);
                delanteLetra = letraTablero;
                delanteNumero = numeroTablero;

                //Detras derecha
                do {
                    int i = delanteLetra;
                    int j = delanteNumero;
                    delanteLetra++;
                    delanteNumero--;
                    i++;
                    j--;
                    tablero[i][j] = verde;
                    tb.setTablero(tablero);
                }while (delanteLetra < tablero.length-1 && delanteNumero > 0);

                return Tablero.NumeroToLetra(letra - 1) + "" + (numero + 1) + ", ";
//            case 2:
//            case 3:
//            case 4:
//            case 6:
//            case 7:
//            case 8:
//            case 9:
               default:
                return "Error";
        }
    }
    public static String DamaOpciones (String[][] tablero, int letra, int numero){

        numero -= 1;
        tablero[letra][numero ] = "\u001B[1;30m\u001B[43m D \u001B[0m";

        String movimientos = "Posibles movimientos: ";
        numero += 1;
        letra +=1;

        if (letra != 1 && numero != 1 && letra != 8 && numero != 8){
            movimientos +=movimiento(1,letra,numero,tablero);
        } else if (letra == 1 && numero == 1) {

        }
        return movimientos;
    }
}
