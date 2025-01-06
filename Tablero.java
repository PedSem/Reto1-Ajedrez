public class Tablero {

    private String[][] tablero = new String[8][8];

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public static final String COLOR_BLANCO = "\u001B[0;107m"; // Fondo blanco brillante
    public static final String COLOR_NEGRO = "\u001B[40m"; // Fondo negro
    public static final String RESET = "\u001B[0m"; // Resetear color
    public static final String COLOR_GRIS = "\u001B[100m"; // Fondo gris
    public static final String COLOR_GRIS_BORDE = "\u001B[0;100m"; // Borde gris
    public static final String COLOR_GRIS_NUMERO = "\u001B[1;3;100m"; // Color para los números en el borde
    public static final String ESPACIO_VACIO = "   "; // Espacio vacío para los cuadros

    public String[][] InicializarTablero() { // Inicializa el tablero en el main poniendo el tablero en blanco y negro
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if ((i + j) % 2 == 0) {
                    tablero[i][j] = COLOR_BLANCO + ESPACIO_VACIO + RESET; // Cuadro blanco
                } else {
                    tablero[i][j] = COLOR_NEGRO + ESPACIO_VACIO + RESET; // Cuadro negro
                }
            }
        }

        return tablero;
    }

    public String[][] getTablero() {
        int c = 8; // Muestra las coordenadas de números por pantalla en el tablero (derecha)

        // Fila de grises de arriba del tablero
        for (int i = 1; i <= 10; i++) {
            System.out.print(COLOR_GRIS + ESPACIO_VACIO);
        }
        System.out.println(RESET); // Reset del color gris

        // Mostrar Tablero por pantalla
        for (int i = tablero.length - 1; i >= 0; i--) {
            System.out.print(COLOR_GRIS_BORDE + ESPACIO_VACIO); // Borde izquierdo del tablero gris
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[j][i]);
            }
            System.out.println(COLOR_GRIS_NUMERO + " " + c + " " + RESET); // Borde derecho del tablero gris + coordenadas de números
            c--; // muestra las coordenadas a la derecha de cada fila
        }

        // Borde inferior del tablero gris + coordenadas de letras
        System.out.print(COLOR_GRIS_BORDE + ESPACIO_VACIO);
        for (int i = 1; i <= 9; i++) {
            if (i <= 8) {
                System.out.print(COLOR_GRIS_NUMERO + " " + NumeroToLetra(i) + " ");
            } else {
                System.out.print(COLOR_GRIS_BORDE + ESPACIO_VACIO);
            }
        }
        System.out.println(RESET);
        System.out.println();

        return tablero;
    }

    public static char NumeroToLetra(int i) {
        // Define la posición con letra depende de la coordenada que le pasen.
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

    public static int LetraToNumero(String letraString) { // Convierte la letra que pones en número. Conforme el tablero
        return switch (letraString) {
            case "a" -> 1;
            case "b" -> 2;
            case "c" -> 3;
            case "d" -> 4;
            case "e" -> 5;
            case "f" -> 6;
            case "g" -> 7;
            case "h" -> 8;
            default -> 0;
        } - 1; // Como el array cuenta desde 0 es necesario restarle 1
    }
}
