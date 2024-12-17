import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean piezas;

        System.out.println("--------------------------");
        System.out.println("""
                Colores:
                (B)lanco
                (N)egro""");
        System.out.print("Introduce la inicial del color de la pieza con la que vas a jugar: ");
        String color = sc.nextLine().toUpperCase(); // Pone minusculas en mayusculas

        // Validacion del la letra del color
        while (!color.equals("B")  && !color.equals("N")) {
            System.out.println("Ese color no es valido, asegurate de introducir la letra inicial del color correctamente.");
            System.out.println("""
                Colores:
                (B)lanco
                (N)egro""");
            System.out.print("Introduce la letra inicial del color de la pieza con la que vas a jugar: ");
            color = sc.nextLine().toUpperCase();
        }

        do {
            piezas = true;
            System.out.println("--------------------------");
            System.out.println("""
                Piezas:
                (R)ey
                (D)ama
                (T)orre
                (A)lfil
                (C)aballo
                (P)eón""");
            System.out.print("Introduce la letra inicial de la pieza con la que vas a jugar: ");
            String pieza = sc.nextLine().toUpperCase(); // Pone minusculas en mayusculas

            switch (pieza) {
                case "R":
                    System.out.println("Has escogido el Rey.");
                    break;
                case "D":
                    System.out.println("Has escogido la Dama.");
                    break;
                case "T":
                    System.out.println("Has escogido la Torre.");
                    break;
                case "A":
                    System.out.println("Has escogido el Alfil");
                    break;
                case "C":
                    System.out.println("Has escogido el Caballo.");
                    break;
                case "P":
                    System.out.println("Has escogido el Peon.");
                    break;
                default:
                    System.out.println("No existe esa pieza.");
                    piezas = false;
                    break;
            }
        } while (!piezas);
        System.out.println("--------------------------");


        System.out.print("Introduce la posición en la que se encuentra la pieza ([a-h] [1-8] Ej. b4): ");
        String posicion = sc.nextLine();


    }
}