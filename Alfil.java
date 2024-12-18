import java.util.Scanner;

public class Alfil {
    static Tablero tb=new Tablero();
    public static String mostrarPosicionAlfil(String[][]tablero){
        //Mostrar
        String AlfilBlanco="U+2657";
        for(int i=0;i< tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                if(tablero[j][i]==AlfilBlanco){
                    return "La posicion es " + columna(j+1) + (i+1);
                }
            }
        }
        return "Error";
    }
    public static char columna(int i){
        return switch (i){
            case 1->'a';
            case 2->'b';
            case 3->'c';
            case 4->'d';
            case 5->'e';
            case 6->'f';
            case 7->'g';
            case 8->'h';
            default -> 'x';
        };
    }
    public static String movimientoAlfil(int coordenada,int letra,int numero,String[][]tablero){
        String verde = "🟩";
        int letratablero=letra-1;
        int numerotablero=numero-1;
        switch (coordenada){
            case 1:
                tablero[letratablero-1][numerotablero+1]=verde;
                tb.setTablero(tablero);
                return columna(letra-1) + "" + (numero+1) + ",";
            case 3:
                tablero[letratablero+1][numerotablero+1]=verde;
                tb.setTablero(tablero);
                return columna(letra-1) + "" + (numero+1) + ",";
            case 7:
                tablero[letratablero-1][numerotablero-1]=verde;
                tb.setTablero(tablero);
                return columna(letra-1) + "" + (numero+1) + ",";
            case 9:
                tablero[letratablero+1][numerotablero-1]=verde;
                tb.setTablero(tablero);
                return columna(letra+1) + "" + (numero+1) + ",";
            default:
                return "Error";



        }

    }
    public static String MainAlfil(String[][]tablero,int letra,int numero){
        String movimientosAlfil="Posibles movimientos: ";
        letra+=1;
        numero+=1;
        if(letra!=1 && numero!=1 && letra!=8 && numero!=8){

        }


    }

}
