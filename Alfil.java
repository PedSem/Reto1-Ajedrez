
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
             int posicionletraatras=letratablero-1;
             int posicionnumeroatras=numerotablero-1;
             int posicionletradelante=letratablero+1;
             int posicionnumerodelante=numerotablero+1;

              String columnamovimientos;//Para almacenar los movimientos de la pieza en la columna
              String resultado="";//Para almacenar los posibles movimientos de la pieza
        /* Los movimientos del alfil
        | 1   3 |
        |   X   |
        | 7   9 |
         */
            switch (coordenada){// Los posibles casos donde el alfil se mueva
                case 1://Diagonal hacia arriba por la izquierda

                    do{//Añado un bucle para contar las casillas en esa direccion

                        tablero[posicionletraatras][posicionnumerodelante]=verde;//Marca las posiciones de los movimientos del alfil
                        tb.setTablero(tablero);

                        columnamovimientos=columna(letra-1) + "" + (numero+1) + ",";//Muestra la columna que esta ahora el alfil en diagonal

                        resultado=resultado+columnamovimientos;//Concateno todos los posibles movimientos

                        letra--;//Simplifico la letra para que coja la siguiente en el tablero
                        numero++;//Aumento el numero para que coja la siguiente en el tablero
                        posicionletraatras--;//Simplifico y aumento aquellas posiciones que se van a marcar en diagonal
                        posicionnumerodelante++;

                    }while (posicionletraatras>=0 && posicionnumerodelante<8);//Comprueba que no se pasa del limite del tablero

                    return resultado;//Devuelve el resultado de esos movimientos del alfil en aquella dirección

                case 3://Diagonal hacia arriba por la derecha

                     do{

                         tablero[posicionletradelante][posicionnumerodelante]=verde;
                         tb.setTablero(tablero);
                         columnamovimientos=columna(letra+1) + "" + (numero+1) + ",";
                         letra++;
                         numero++;
                         posicionletradelante++;
                         posicionnumerodelante++;
                         resultado=resultado + columnamovimientos;
                     }while ( posicionletradelante<8 && posicionnumerodelante<8);
                     return resultado;

                case 7://Diagonal hacia abajo por la izquierda

                    do{
                        tablero[posicionletraatras][posicionnumeroatras]=verde;
                        tb.setTablero(tablero);
                        columnamovimientos=columna(letra-1) + "" + (numero-1) + ",";
                        letra--;
                        numero--;
                        posicionletraatras--;
                        posicionnumeroatras--;
                        resultado=resultado + columnamovimientos;

                    }while ( posicionnumeroatras>=0 && posicionletraatras>=0);

                   return resultado;

                case 9://Diagonal hacia abajo por la derecha

                    do{
                        tablero[posicionletradelante][posicionnumeroatras]=verde;
                        tb.setTablero(tablero);
                        columnamovimientos=columna(letra+1) + "" + (numero-1) + ",";
                        letra++;
                        numero--;
                        posicionletradelante++;
                        posicionnumeroatras--;
                        resultado = resultado +columnamovimientos;

                    }while (posicionnumeroatras>=0 && posicionletradelante<8);

                    return resultado;

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
            movimientosAlfil+=movimientoAlfil(1,letra,numero,tablero) + movimientoAlfil(7,letra,numero,tablero);
        }
        return movimientosAlfil;


    }

}
