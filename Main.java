import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean piezas;

        System.out.println("--------------------------");
        System.out.println("""
                Colores:
                (B)lanco
                (N)egro""");
        System.out.print("De que color es la pieza? ");
        String color = sc.nextLine().toUpperCase(); // Pone minusculas en mayusculas

        // Validacion del la letra del color
        while (!color.equals("B")  && !color.equals("N")) {
            System.out.println("Ese color no es valido, asegurate de poner la letra correctamente");
            System.out.println("""
                Colores:
                (B)lanco
                (N)egro""");
            System.out.print("De que color es la pieza? ");
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
            System.out.print("Que pieza eliges? ");
            String pieza = sc.nextLine().toUpperCase(); // Pone minusculas en mayusculas

            switch (pieza) {
                case "R":
                    System.out.println("Has escogido el rey");
                    break;
                case "D":
                    System.out.println("Has escogido la dama");
                    break;
                case "T":
                    System.out.println("Has escogido la torre");
                    break;
                case "A":
                    System.out.println("Has escogido el alfil");
                    break;
                case "C":
                    System.out.println("Has escogido el caballo");
                    break;
                case "P":
                    System.out.println("Has escogido el peon");
                    break;
                default:
                    System.out.println("No existe esa pieza");
                    piezas = false;
                    break;
            }
        } while (!piezas);
        System.out.println("--------------------------");


        System.out.print("En que posicion se encuentra ((a-h) (1-8) ej. b4)? ");
        String posicion = sc.nextLine();


    }
}