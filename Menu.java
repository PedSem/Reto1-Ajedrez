import java.sql.Array;
import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pieza;
        String color;
        String posicion = "";
        String nombrePieza = ""; // Variable para almacenar el nombre completo de la pieza


        // Menú de selección de piezas
        do {
            System.out.println("====================================");
            System.out.println("          Selección de Piezas:      ");
            System.out.println("====================================");
            System.out.println("""
                    (R)ey
                    (D)ama
                    (T)orre
                    (A)lfil
                    (C)aballo
                    (P)eón""");
            System.out.print("Introduce la letra inicial de la pieza con la que vas a jugar: ");
            pieza = sc.nextLine().toUpperCase(); // Pone minúsculas en mayúsculas
            System.out.println(); //Para dejar espacio con la respuesta

            switch (pieza) {
                case "R":
                    System.out.println("Has escogido el Rey.");
                    nombrePieza="Rey";
                    break;
                case "D":
                    System.out.println("Has escogido la Dama.");
                    nombrePieza="Dama";
                    break;
                case "T":
                    System.out.println("Has escogido la Torre.");
                    nombrePieza="Torre";
                    break;
                case "A":
                    System.out.println("Has escogido el Alfil");
                    nombrePieza="Alfil";
                    break;
                case "C":
                    System.out.println("Has escogido el Caballo.");
                    nombrePieza="Caballo";
                    break;
                case "P":
                    System.out.println("Has escogido el Peón.");
                    nombrePieza="Peón";
                    break;
                default:
                    System.out.println("No existe esa pieza. Por favor, elige una válida.");
                    System.out.println();
                    pieza = ""; // Reiniciar la selección
                    break;
            }
        } while (pieza.isEmpty());
        System.out.println();


        // Menú de selección de colores
        do {
            System.out.println("====================================");
            System.out.println("          Selección de Colores:     ");
            System.out.println("====================================");
            System.out.println("""
                    (B)lanco
                    (N)egro""");
            System.out.print("Introduce la letra inicial del color de la pieza con la que vas a jugar: ");
            color = sc.nextLine().toUpperCase(); // Pone minúsculas en mayúsculas
            System.out.println();

            if (!color.equals("B") && !color.equals("N")) {
                System.out.println("Ese color no es válido, asegurate de introducir la letra inicial del color correctamente.");
                System.out.println();
            }
        } while (!color.equals("B") && !color.equals("N"));

        if (color.equals("B")){
            System.out.println("Has escogido jugar con las piezas Blancas.");
        }
        if (color.equals("N")){
            System.out.println("Has escogido jugar con las piezas Negras.");
        }
        System.out.println();

        // Menú de selección de posición
        boolean posicionValida = false; 

        do {
            System.out.println("====================================");
            System.out.println("          Selección de Posición     ");
            System.out.println("====================================");
            System.out.print("Introduce la posición en la que se encuentra la pieza ([a-h][1-8], Ej. b4): ");
            posicion = sc.nextLine().toLowerCase(); // Para que las mayusculas se pongan en minusculas

            if (posicion.length() == 2) {
                char letra = posicion.charAt(0); // La letra siempre está en la primera posición
                char numero = posicion.charAt(1); // El número siempre está en la segunda posición

                // Verificar si letra y número están en los rangos correctos
                if (letra >= 'a' && letra <= 'h' && numero >= '1' && numero <= '8') {
                    posicionValida = true; // Entrada válida, salir del bucle
                } else {
                    System.out.println("Las coordenadas que has introducido son incorrectas. Inténtalo de nuevo.");
                    System.out.println();
                }
            } else {
                System.out.println("Las coordenadas deben tener exactamente 2 caracteres (Ej. b4). Inténtalo de nuevo.");
                System.out.println();
            }
        } while (!posicionValida);

        System.out.println();

        // Resumen de la selección
        System.out.println("====================================");
        System.out.println("          Resumen de Selección      ");
        System.out.println("====================================");
        System.out.println("Pieza: " + nombrePieza);
        System.out.println("Color: " + (color.equals("B") ? "Blanco" : "Negro"));
        System.out.println("Posición: " + posicion);
        System.out.println("====================================");

        sc.close();
    }
}