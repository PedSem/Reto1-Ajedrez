import java.util.Scanner;

public class AjedrezReto1 {
    // Muestra la posicion de la pieza en el tablero.
    public static void mostrarPosicion(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[j][i] == 1) {
                    System.out.println("La posicion es " + columna(j + 1) + (i + 1));
                }
            }
        }
    }
    public static int scanner() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() - 1;
    }
    public static String movimiento (int i, int letra, int numero, int[][] tablero) {
        /*
        | 1 2 3 |
        | 4 X 5 |
        | 7 8 9 |

        X es la posicion del rey y los numero los posibles movimientos
         */
        int letraTablero = letra - 1;
        int numeroTablero = numero - 1;
        switch (i) {
            case 1:
                tablero[letraTablero - 1][numeroTablero + 1] = 2;
                return columna(letra - 1) + "" + (numero + 1) + ", ";
            case 2:
                tablero[letraTablero][numeroTablero + 1] = 2;
                return columna(letra) + "" + (numero + 1) + ", ";
            case 3:
                tablero[letraTablero + 1][numeroTablero + 1] = 2;
                return columna(letra + 1) + "" + (numero + 1) + ", ";
            case 4:
                tablero[letraTablero - 1][numeroTablero] = 2;
                return columna(letra - 1) + "" + numero + ", ";
            case 6:
                tablero[letraTablero + 1][numeroTablero] = 2;
                return columna(letra + 1) + "" + numero + ", ";
            case 7:
                tablero[letraTablero - 1][numeroTablero - 1] = 2;
                return columna(letra - 1) + "" + (numero - 1) + ", ";
            case 8:
                tablero[letraTablero][numeroTablero - 1] = 2;
                return columna(letra) + "" + (numero - 1) + ", ";
            case 9:
                tablero[letraTablero + 1][numeroTablero - 1] = 2;
                return columna(letra + 1) + "" + (numero - 1);
            default:
                return "Error";
        }
    }
    public static char columna(int i) {
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
    public static void main(String[] args) {
        int[][] tablero = new int[8][8];

        Scanner sc = new Scanner(System.in);
        System.out.print("Letra: ");
        String letraString = sc.nextLine(); // Esto es la coordenada de las letras
        System.out.print("Número: ");
        int numero = scanner(); // Esto es la coordenada de los numero
        int letra = switch (letraString) {
            case "a" -> 1;
            case "b" -> 2;
            case "c" -> 3;
            case "d" -> 4;
            case "e" -> 5;
            case "f" -> 6;
            case "g" -> 7;
            case "h" -> 8;
            default -> 0;
        } - 1;

        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                tablero [j][i] = 0;
            }
        }

        // Define la posicion del rey en el tablero con un 1
        tablero[letra][numero] = 1;

        int c = 8; // Muestra las coordenadas de numeros por pantalla en el tablero

        mostrarPosicion(tablero);

        String movimientos = "Posibles movimientos: ";
        letra += 1;
        numero += 1;
        if (letra != 1 && numero != 1 && letra != 8 && numero != 8) {
            System.out.println("Está dentro");

            // Posibles Movimientos del rey dentro de los bordes del tablero
            movimientos += movimiento(1, letra, numero, tablero) + movimiento(2, letra, numero, tablero) + movimiento(3, letra, numero, tablero) + movimiento(4, letra, numero, tablero) + movimiento(6, letra, numero, tablero) + movimiento(7, letra, numero, tablero) + movimiento(8, letra, numero, tablero) + movimiento(9, letra, numero, tablero);

        } else if (letra == 1 && numero == 1){
            System.out.println("Esquina");

            // Posibles Movimientos del rey en la esquina inferior izquierda
            movimientos += movimiento(2, letra, numero, tablero) + movimiento(3, letra, numero, tablero) + movimiento(6, letra, numero, tablero);

        } else if (letra == 1 && numero == 8) {
            System.out.println("Esquina");

            // Posibles Movimientos del rey en la esquina superior izquierda
            movimientos += movimiento(6, letra, numero, tablero) + movimiento(8, letra, numero, tablero) + movimiento(9, letra, numero, tablero);

        } else if (letra == 8 && numero == 8) {
            System.out.println("Esquina");

            // Posibles Movimientos del rey en la esquina superior derecha
            movimientos += movimiento(4, letra, numero, tablero) + movimiento(7, letra, numero, tablero) + movimiento(8, letra, numero, tablero);

        } else if (letra == 8 && numero == 1) {
            System.out.println("Esquina");

            // Posibles Movimientos del rey en la esquina inferior derecha
            movimientos += movimiento(1, letra, numero, tablero) + movimiento(2, letra, numero, tablero) + movimiento(4, letra, numero, tablero);

        } else if (numero == 1) {
            System.out.println("Borde");

            // Posibles Movimientos del rey en el borde inferior (sin esquinas)
            movimientos += movimiento(1, letra, numero, tablero) + movimiento(2, letra, numero, tablero) + movimiento(3, letra, numero, tablero) + movimiento(4, letra, numero, tablero) + movimiento(6, letra, numero, tablero);
        } else if (letra == 1) {
            System.out.println("Borde");

            // Posibles Movimientos del rey en el borde izquierdo (sin esquinas)
            movimientos += movimiento(2, letra, numero, tablero) + movimiento(3, letra, numero, tablero) + movimiento(6, letra, numero, tablero) + movimiento(8, letra, numero, tablero) + movimiento(9, letra,numero, tablero);
        } else if (numero == 8) {
            System.out.println("Borde");

            // Posibles Movimientos del rey en el borde superior (sin esquinas)
            movimientos += movimiento(4, letra, numero, tablero) + movimiento(6, letra, numero, tablero) + movimiento(7, letra, numero, tablero) + movimiento(8, letra, numero, tablero) + movimiento(9, letra, numero, tablero);
        } else {
            System.out.println("Borde");

            // Posibles Movimientos del rey en el borde superior (sin esquinas)
            movimientos += movimiento(1, letra, numero, tablero) + movimiento(2, letra, numero, tablero) + movimiento(4, letra, numero, tablero) + movimiento(7, letra, numero, tablero) + movimiento(8, letra, numero, tablero);
        }
        // Mostrar Tablero por pantalla
        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[j][i] + " ");
            }
            System.out.println("| " + c);
            c--;
        }
        System.out.println("---------------");
        System.out.println("a b c d e f g h"); // Muestra por pantalla las coordenadas de las letras en el tablero
        System.out.println();

        System.out.println(movimientos);

    }
}
