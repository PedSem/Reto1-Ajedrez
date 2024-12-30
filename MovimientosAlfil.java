
public class MovimientosAlfil {
    static Tablero tb=new Tablero();


    public static String movimiento(int coordenada,int letra,int numero,String[][]tablero){
            String verde = "\u001B[1m\u001B[42m · \u001B[0m";
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


                        tablero[posicionletraatras][posicionnumerodelante]=verde;//Marca las coordenadas de los movimientos del alfil
                        tb.setTablero(tablero);//Modifica el objeto tablero

                        columnamovimientos=Tablero.NumeroToLetra(letra-1)+ "" + (numero+1) + ", ";//Declaro en String la posicion en que se encuentra el alfil

                        resultado+=columnamovimientos;//Concateno todos los posibles movimientos en esa direccion
                        //Decremento y aumento la letra y el numero del tablero para poner la posicion en la que esta ahora
                        letra--;
                        numero++;
                        //Decremento y aumento las posiciones hacia donde va a ir el alfil
                        posicionletraatras--;
                        posicionnumerodelante++;




                    }while (posicionletraatras>=0 && posicionnumerodelante<8);//Comprueba que no se pasa del limite del tablero

                    return resultado;//Devuelve el resultado de esos movimientos del alfil en aquella dirección

                case 3://Diagonal hacia arriba por la derecha
                     do{

                         tablero[posicionletradelante][posicionnumerodelante]=verde;
                         tb.setTablero(tablero);
                         columnamovimientos=Tablero.NumeroToLetra(letra+1) + "" + (numero+1) + ", ";
                         letra++;
                         numero++;
                         posicionletradelante++;
                         posicionnumerodelante++;
                         resultado+=columnamovimientos;
                     }while ( posicionletradelante<8 && posicionnumerodelante<8);
                     return resultado;

                case 7://Diagonal hacia abajo por la izquierda
                    do{
                        tablero[posicionletraatras][posicionnumeroatras]=verde;
                        tb.setTablero(tablero);
                        columnamovimientos=Tablero.NumeroToLetra(letra-1) + "" + (numero-1) + ", ";
                        letra--;
                        numero--;
                        posicionletraatras--;
                        posicionnumeroatras--;
                        resultado+=columnamovimientos;

                    }while ( posicionnumeroatras>=0 && posicionletraatras>=0);

                   return resultado;

                case 9://Diagonal hacia abajo por la derecha
                    do{
                        tablero[posicionletradelante][posicionnumeroatras]=verde;
                        tb.setTablero(tablero);
                        columnamovimientos=Tablero.NumeroToLetra(letra+1) + "" + (numero-1) + ", ";
                        letra++;
                        numero--;
                        posicionletradelante++;
                        posicionnumeroatras--;
                        resultado+=columnamovimientos;

                    }while (posicionnumeroatras>=0 && posicionletradelante<8);
                    return resultado;

                default:
                    return "Error";



            }



    }
    public static String PosicionesAlfil(String[][]tablero,int letra,int numero,String color){
        String movimientosAlfil="Posibles movimientos: ";
        numero-=1;
        if(color.equals("B")){
            tablero[letra][numero]="\u001B[1;30m\u001B[43m ♗ \u001B[0m";
        }else{
            tablero[letra][numero]="\u001B[1;30m\u001B[43m ♝ \u001B[0m";
        }
        letra+=1;
        numero+=1;
        if(color.equals("B") && ((letra+numero)%2!=0)){ //Condicion para que se mueva solo en blancas o negras
            return "La pieza debe moverse solo en direcciones blancas";

        }else if(color.equals("N") && (letra+numero)%2==0){
            return "La pieza debe moverse solo en direcciones negras";
        }else{
            if(letra!=1 && numero!=1 && letra!=8 && numero!=8){ //Los posibles movimientos del alfil fuera de los bordes del tablero

                movimientosAlfil+=movimiento(1,letra,numero,tablero) + movimiento(3,letra,numero,tablero) + movimiento(7,letra,numero,tablero) + movimiento(9,letra,numero,tablero);

            }else if(letra==1 && numero==1){ //Posibles movimientos del alfil en el borde izquierdo inferior

                movimientosAlfil+=movimiento(3,letra,numero,tablero);
            }else if(letra==8 && numero==8){ //Posibles movimientos del alfil en el borde derecho superior

                movimientosAlfil+=movimiento(7,letra,numero,tablero);
            }else if(letra==1 && numero==8){ //Posibles movimientos del alfil en el borde izquierdo superior

                movimientosAlfil+=movimiento(9,letra,numero,tablero);
            }else if(letra==8 && numero==1){ //Posibles movimientos del alfil en el borde derecho inferior
                movimientosAlfil+=movimiento(1,letra,numero,tablero);

            }else if(numero==1){ //Posibles movimientos del alfil en el borde inferior(sin esquinas)
                movimientosAlfil+=movimiento(1,letra,numero,tablero) + movimiento(3,letra,numero,tablero);

            }else if(letra==1){ //Posibles movimientos del alfil en el borde izquierdo(sin esquinas)
                movimientosAlfil+=movimiento(3,letra,numero,tablero) + movimiento(9,letra,numero,tablero);

            }else if(numero==8){ //Posibles movimientos del alfil en el borde superior(sin esquinas)
                movimientosAlfil+=movimiento(7,letra,numero,tablero) + movimiento(9,letra,numero,tablero);
            }else{
                //Posibles movimientos del alfil en el borde derecho(sin esquinas)
                movimientosAlfil+=movimiento(1,letra,numero,tablero) + movimiento(7,letra,numero,tablero);
            }
        }
        return movimientosAlfil;


    }

}
