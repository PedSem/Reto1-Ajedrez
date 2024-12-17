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
}