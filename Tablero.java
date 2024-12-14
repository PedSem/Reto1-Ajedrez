public class Tablero {

    private String[][] tablero = new String[8][8];

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public String[][] getTablero() {
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++) {
                if ((i + j ) % 2 != 0){
                    tablero[i][j] = "⬛ ";
                } else {
                    tablero[i][j] = "⬜ ";
                }
            }
        }
        for (int i = 0; i <tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
        return tablero;
    }
}