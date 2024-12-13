import java.util.Scanner;

public class AjedrezReto1 {
    // Muestra la posicion de la pieza en el tablero.
    public static void mostrarPosicion(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[j][i] == 1) {
                    System.out.println("La posicion es " + (j + 1) + (i + 1));
                }
            }
        }
    }
    public static int scanner() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() - 1;
    }
    public static void main(String[] args) {
        char[][] tablero = new char[8][8];

        System.out.print("Letra: ");
        int letra = scanner(); // Esto es la coordenada de las letras
        System.out.print("Numero: ");
        int numero = scanner(); // Esto es la coordenada de los numero


        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                tablero [j][i] = 0;
            }
        }

        tablero[letra][numero] = 1;

        // Revertir Tablero
        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[j][i] + " ");
            }
            System.out.println();
        }

        mostrarPosicion(tablero);

        letra += 1;
        numero += 1;
        if (letra != 1 && numero != 1 && letra != 8 && numero != 8) {
            System.out.println("Esta dentro");

            String movimientos = "";
            movimientos += ((letra - 1) + "" + numero + ", ");
            movimientos += ((letra + 1) + "" + numero + ", ");
            movimientos += (letra + "" + (numero + 1) + ", ");
            movimientos += (letra + "" + (numero - 1) + ", ");
            movimientos += ((letra - 1) + "" + (numero - 1) + ", ");
            movimientos += ((letra - 1) + "" + (numero + 1) + ", ");
            movimientos += ((letra + 1) + "" + (numero + 1) + ", ");
            movimientos += ((letra + 1) + "" + (numero - 1));

            System.out.println(movimientos);

            switch (letra) {
                case 1:

            }
        } else System.out.println("Fuera");

    }
}
