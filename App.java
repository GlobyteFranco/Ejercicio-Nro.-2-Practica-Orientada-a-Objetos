import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Ingrese el valor a convertir en fraccion. \n Tenga en cuenta que solo debe ingresar un valor con decimales para que se haga la conversion");
        float operandA = sc.nextFloat();
        float operandB = sc.nextFloat();

        while (operandA != 0 || operandB != 0) {
            System.out.println("La fraccion obtenida es" + new Fraccion(operandA, operandB));
            operandA = sc.nextFloat();
            operandB = sc.nextFloat();
        }
        ;
        sc.close();
        System.out.println(
                "Programa terminado. \n Muchas gracias por probarlo!!!");

    }
}