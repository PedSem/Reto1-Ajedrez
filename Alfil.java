
//Falta comprobar que cuente todas las posiciones en el alfil
public class Alfil {
    static Tablero tb=new Tablero();
    public static String mostrarPosicionAlfil(String[][]tablero){
        //Mostrar la posicion del tablero
        String AlfilBlanco="♗";
        for(int i=0;i< tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                if(tablero[j][i].equals(AlfilBlanco)){
                    return "La posicion es " + columna(j + 1) + (i + 1);
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
        /* Los movimientos del alfil
        | 1   3 |
        |   X   |
        | 7   9 |
         */
            switch (coordenada){// Los posibles casos donde el alfil se mueva
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
    public static String PosicionesAlfil(String[][]tablero,int letra,int numero){
        String movimientosAlfil="Posibles movimientos: ";
        numero-=1;
        tablero[letra][numero]="♗";

        letra+=1;
        numero+=1;

        /*
        if(letra!=1 && numero!=1 && letra!=8 && numero!=8){ //Los posibles movimientos del alfil fuera de los bordes del tablero

            movimientosAlfil+=movimientoAlfil(1,letra,numero,tablero) + movimientoAlfil(3,letra,numero,tablero) + movimientoAlfil(7,letra,numero,tablero) + movimientoAlfil(9,letra,numero,tablero);

        }else if(letra==1 && numero==1){ //Posibles movimientos del alfil en el borde izquierdo inferior

            movimientosAlfil+=movimientoAlfil(3,letra,numero,tablero);
        }else if(letra==8 && numero==8){ //Posibles movimientos del alfil en el borde derecho superior

            movimientosAlfil+=movimientoAlfil(7,letra,numero,tablero);
        }else if(letra==1 && numero==8){ //Posibles movimientos del alfil en el borde izquierdo superior

            movimientosAlfil+=movimientoAlfil(9,letra,numero,tablero);
        }else if(letra==8 && numero==1){ //Posibles movimientos del alfil en el borde derecho inferior
            movimientosAlfil+=movimientoAlfil(1,letra,numero,tablero);

        }else if(numero==1){ //Posibles movimientos del alfil en el borde inferior(sin esquinas)
            movimientosAlfil+=movimientoAlfil(1,letra,numero,tablero) + movimientoAlfil(3,letra,numero,tablero);

        }else if(letra==1){ //Posibles movimientos del alfil en el borde izquierdo(sin esquinas)
            movimientosAlfil+=movimientoAlfil(3,letra,numero,tablero) + movimientoAlfil(9,letra,numero,tablero);
        }else if(numero==8){ //Posibles movimientos del alfil en el borde superior(sin esquinas)
            movimientosAlfil+=movimientoAlfil(7,letra,numero,tablero) + movimientoAlfil(9,letra,numero,tablero);
        }else{
            //Posibles movimientos del alfil en el borde superior(sin esquinas)
            movimientosAlfil+=movimientoAlfil(7,letra,numero,tablero) + movimientoAlfil(9,letra,numero,tablero);
        }

         */

        if(letra==8 && numero==1){
            movimientosAlfil+=movimientoAlfil(1,letra,numero,tablero);


        }
        return movimientosAlfil;


    }

}
