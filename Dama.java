public class Dama {
    public static void PiezaDama (String letraString, int numero) {
        Tablero tb = new Tablero();
        String[][] tablero;

        // La letra que introduces es visual y hay que volver a ponerla como numero.
        int letra = Tablero.LetraToNumero(letraString);


        tablero = tb.InicializarTablero();
        String movimientos = (DamaOpciones(tablero,letra,numero));
        tb.getTablero();
        System.out.println(movimientos);
    }



        static Tablero tb = new Tablero();
        public static String movimiento (int letra, int numero, String[][] tablero){
            String verde = "\u001B[1m\u001B[42m · \u001B[0m";
            int letraTablero = letra - 1;
            int numeroTablero = numero - 1;
            String cordenadas;

            if (letraTablero == 0 && numeroTablero == 0) { // Esquina Inferior Izquierda
                HaciaDelante(numeroTablero, letraTablero, tablero, verde);
                HaciaDerecha(numeroTablero, letraTablero, tablero, verde);
                diagonalArribaDerecha(letraTablero, numeroTablero, tablero, verde);
                cordenadas = posiciones(tablero,verde);

            } else if (letraTablero == 0 && numeroTablero == tablero.length -1) { // Esquina Superior Izquierda
                HaciaAtras(numeroTablero, letraTablero, tablero, verde);
                HaciaDerecha(numeroTablero, letraTablero, tablero, verde);
                diagonalBajoDerecha(letraTablero, numeroTablero, tablero, verde);
                cordenadas = posiciones(tablero,verde);

            } else if (letraTablero == tablero.length -1 && numeroTablero == 0) { //Esquina Inferior Derecha
                HaciaDelante(numeroTablero, letraTablero, tablero, verde);
                HaciaIzquierda(numeroTablero, letraTablero, tablero, verde);
                diagonalArribaIzquierda(letraTablero, numeroTablero, tablero, verde);
                cordenadas = posiciones(tablero,verde);

            } else if (letraTablero == tablero.length -1 && numeroTablero == tablero.length -1) { //Esquina Superior Derecha
                HaciaAtras(numeroTablero, letraTablero, tablero, verde);
                HaciaIzquierda(numeroTablero, letraTablero, tablero, verde);
                diagonalBajoIzquierda(letraTablero, numeroTablero, tablero, verde);
                cordenadas = posiciones(tablero,verde);

            } else if (letraTablero == 0) { // Lateral izquierdo
                HaciaDelante(numeroTablero, letraTablero, tablero, verde);
                HaciaAtras(numeroTablero, letraTablero, tablero, verde);
                HaciaDerecha(numeroTablero, letraTablero, tablero, verde);
                diagonalArribaDerecha(letraTablero, numeroTablero, tablero, verde);
                diagonalBajoDerecha(letraTablero, numeroTablero, tablero, verde);
                cordenadas = posiciones(tablero,verde);

            } else if (letraTablero == tablero.length -1) { // Lateral derecho
                HaciaDelante(numeroTablero, letraTablero, tablero, verde);
                HaciaAtras(numeroTablero, letraTablero, tablero, verde);
                HaciaIzquierda(numeroTablero, letraTablero, tablero, verde);
                diagonalArribaIzquierda(letraTablero, numeroTablero, tablero, verde);// ↖
                diagonalBajoIzquierda(letraTablero, numeroTablero, tablero, verde); // ↙
                cordenadas = posiciones(tablero, verde);
            }

            else if (numeroTablero == 0) { //Parte inferior
                HaciaDelante(numeroTablero, letraTablero, tablero, verde);// ⬆
                HaciaIzquierda(numeroTablero, letraTablero, tablero, verde); // ⬅
                HaciaDerecha(numeroTablero, letraTablero, tablero, verde);// ➡
                diagonalArribaIzquierda(letraTablero, numeroTablero, tablero, verde);// ↖
                diagonalArribaDerecha(letraTablero, numeroTablero, tablero, verde); // ↗
                cordenadas = posiciones(tablero, verde);

            } else if (numeroTablero == tablero.length -1) { //Parte superior
                HaciaAtras(numeroTablero, letraTablero, tablero, verde);  // ⬇
                HaciaDerecha(numeroTablero, letraTablero, tablero, verde); // ➡
                HaciaIzquierda(numeroTablero, letraTablero, tablero, verde); // ⬅
                diagonalBajoDerecha(letraTablero, numeroTablero, tablero, verde);// ↘
                diagonalBajoIzquierda(letraTablero, numeroTablero, tablero, verde); // ↙
                cordenadas = posiciones(tablero, verde);

            } else {
                HaciaDelante(numeroTablero, letraTablero, tablero, verde); // ⬆
                HaciaAtras(numeroTablero, letraTablero, tablero, verde);  // ⬇
                HaciaDerecha(numeroTablero, letraTablero, tablero, verde); // ➡
                HaciaIzquierda(numeroTablero, letraTablero, tablero, verde); // ⬅
                diagonalArribaDerecha(letraTablero, numeroTablero, tablero, verde);// ↗
                diagonalBajoDerecha(letraTablero, numeroTablero, tablero, verde);// ↘
                diagonalArribaIzquierda(letraTablero, numeroTablero, tablero, verde);// ↖
                diagonalBajoIzquierda(letraTablero, numeroTablero, tablero, verde); // ↙
                cordenadas = posiciones(tablero,verde);
            }
            return cordenadas;

        }
        public static String DamaOpciones (String[][] tablero, int letra, int numero){

            numero -= 1;
            tablero[letra][numero ] = "\u001B[1;30m\u001B[43m D \u001B[0m";

            String movimientos = "Posibles movimientos: ";
            numero += 1;
            letra +=1;

            movimientos += movimiento(letra,numero,tablero);

            return movimientos;
        }

        public static void HaciaAtras(int numeroTablero,int letraTablero,String[][] tablero,String verde){
            for (int Atras = numeroTablero -1 ; Atras >= 0;Atras--) {
                tablero[letraTablero][Atras] = verde;
                tb.setTablero(tablero);
            }
        }

        public static void HaciaDelante(int numeroTablero,int letraTablero,String[][] tablero,String verde){
            for ( int Arriba = numeroTablero  + 1; Arriba < tablero.length;Arriba++){
                tablero[letraTablero][Arriba] = verde;
                tb.setTablero(tablero);
            }
        }

        public static void HaciaDerecha(int numeroTablero,int letraTablero,String[][] tablero,String verde){
            for (int Derecha = letraTablero + 1; Derecha <= tablero.length -1 ; Derecha++){
                tablero[Derecha][numeroTablero] = verde;
                tb.setTablero(tablero);
            }
        }

        public static void HaciaIzquierda(int numeroTablero,int letraTablero,String[][] tablero,String verde){
            for (int Izquierda = letraTablero - 1; Izquierda >= 0; Izquierda--){
                tablero[Izquierda][numeroTablero] = verde;
                tb.setTablero(tablero);
            }
        }

        public static void diagonalBajoDerecha(int letraTablero,int numeroTablero,String[][] tablero,String verde){
            do {
                int i = letraTablero;
                int j = numeroTablero;
                letraTablero++;
                numeroTablero--;
                i++;
                j--;
                tablero[i][j] = verde;
                tb.setTablero(tablero);
            }while (letraTablero < tablero.length-1 && numeroTablero > 0);

        }

        public static void diagonalArribaDerecha(int letraTablero,int numeroTablero,String[][] tablero,String verde){
            do {
                int i = letraTablero;
                int j = numeroTablero;
                letraTablero++;
                numeroTablero++;
                i++;
                j++;
                tablero[i][j] = verde;
                tb.setTablero(tablero);
            } while (letraTablero < tablero.length -1 && numeroTablero < tablero.length -1);

        }

        public static void diagonalBajoIzquierda(int letraTablero,int numeroTablero,String[][] tablero,String verde){
            do {
                int i = letraTablero;
                int j = numeroTablero;
                letraTablero--;
                numeroTablero--;
                i--;
                j--;
                tablero[i][j] = verde;
                tb.setTablero(tablero);
            }while (letraTablero > 0 && numeroTablero > 0);
        }

        public static void diagonalArribaIzquierda(int letraTablero,int numeroTablero,String[][] tablero,String verde){
            do {
                int i = letraTablero;
                int j = numeroTablero;
                letraTablero--;
                numeroTablero++;
                i--;
                j++;
                tablero[i][j] = verde;
                tb.setTablero(tablero);
            } while (letraTablero > 0 && numeroTablero < tablero.length - 1);
        }

        public static String posiciones(String[][] tablero,String verde){
            String posicion = "";
            for (int i = 0; i < tablero.length ; i++){
                for (int j = 0; j < tablero[i].length  ; j++){
                    if (tablero[i][j].equals(verde)){
                        int fila = i + 1;
                        int columna = j + 1;
                        posicion += Tablero.NumeroToLetra(fila) + "" + columna + ", ";
                    }
                }
            }
            return posicion;
        } //Guarda en que cordenadas estan las casillas verdes
}

