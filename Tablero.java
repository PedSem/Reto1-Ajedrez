public class Tablero {

    private int[][] tablero = new int[8][8];

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int[][] getTablero() {
        int c = 8; // Muestra las coordenadas de numeros por pantalla en el tablero (derecha)

        // Mostrar Tablero por pantalla
        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[j][i] + "  ");
            }
            System.out.println("| " + c);
            c--;
        }

        System.out.println("------------------------"); // Separador
        System.out.println("a  b  c  d  e  f  g  h"); // Muestra por pantalla las coordenadas de las letras en el tablero.
        System.out.println();

        return tablero;
    }
}