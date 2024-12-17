import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pieza;
        String color;
        String posicion;
        String nombrePieza = ""; // Variable para almacenar el nombre completo de la pieza

        // Menú de selección de piezas
        System.out.println("====================================");
        System.out.println("          Selección de Piezas      ");
        System.out.println("====================================");
        do {
            System.out.println("""
                    Piezas:
                    (R)ey
                    (D)ama
                    (T)orre
                    (A)lfil
                    (C)aballo
                    (P)eón""");
            System.out.print("¿Qué pieza eliges? ");
            pieza = sc.nextLine().toUpperCase(); // Pone minúsculas en mayúsculas

            switch (pieza) {
                case "R":
                    nombrePieza = "Rey";
                    System.out.println("Has escogido el rey");
                    break;
                case "D":
                    nombrePieza = "Dama";
                    System.out.println("Has escogido la dama");
                    break;
                case "T":
                    nombrePieza = "Torre";
                    System.out.println("Has escogido la torre");
                    break;
                case "A":
                    nombrePieza = "Alfil";
                    System.out.println("Has escogido el alfil");
                    break;
                case "C":
                    nombrePieza = "Caballo";
                    System.out.println("Has escogido el caballo");
                    break;
                case "P":
                    nombrePieza = "Peón";
                    System.out.println("Has escogido el peón");
                    break;
                default:
                    System.out.println("No existe esa pieza. Por favor, elige una válida.");
                    pieza = ""; // Reiniciar la selección
                    break;
            }
        } while (pieza.isEmpty());

        // Menú de selección de colores
        System.out.println("====================================");
        System.out.println("          Selección de Colores     ");
        System.out.println("====================================");
        do {
            System.out.println("""
                    Colores:
                    (B)lanco
                    (N)egro""");
            System.out.print("¿De qué color es la pieza? ");
            color = sc.nextLine().toUpperCase(); // Pone minúsculas en mayúsculas

            if (!color.equals("B") && !color.equals("N")) {
                System.out.println("Ese color no es válido, asegúrate de poner la letra correctamente.");
            }
        } while (!color.equals("B") && !color.equals("N"));

        // Menú de selección de posición
        System.out.println("====================================");
        System.out.println("          Selección de Posición     ");
        System.out.println("====================================");
        System.out.print("¿En qué posición se encuentra ((a-h) (1-8) ej. b4)? ");
        posicion = sc.nextLine();

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