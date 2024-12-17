public class Tablero {

    private String[][] tablero = new String[8][8];

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public String[][] InicializarTablero(){ // Inizaliza el tablero en el main poniendo el tablero en blanco y negro
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if ((i + j) % 2 != 0) {
                    tablero[i][j] = "◻️";
                } else {
                    tablero[i][j] = "⬛";
                }
            }
        }

        return tablero;
    }

    public String[][] getTablero() {
        int c = 8; // Muestra las coordenadas de numeros por pantalla en el tablero (derecha)



        // Mostrar Tablero por pantalla
        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[j][i] + " ");
            }
            System.out.println("| " + c);
            c--; // muestra las coordenadas a la derecha de cada fila
        }

        System.out.println("---------------------------"); // Separador
        System.out.println(" A  B  C   D  E   F  G  H"); // Muestra por pantalla las coordenadas de las letras en el tablero.
        System.out.println();

        return tablero;
    }

    //Para no tener que crear en cada pieza un metodo columna, lo he puesto en tablero asi solo habra que llamarlo desde la clase Tablero (Tablero.columna)
    public static char columna(int i) {
        // Define la posicion con letra depende de la coordenada que le pasen.
        return switch (i) {
            case 1 -> 'a';
            case 2 -> 'b';
            case 3 -> 'c';
            case 4 -> 'd';
            case 5 -> 'e';
            case 6 -> 'f';
            case 7 -> 'g';
            case 8 -> 'h';
            default -> 'x';
        };
    }
}