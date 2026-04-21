import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Ingrese el valor a convertir en fraccion. \n Tenga en cuenta que solo debe ingresar un valor con decimales para que se haga la conversion");
        float operandA = sc.nextFloat();
        do {
            System.out.println(
                    "El valor elegido es el siguiente: \n\n " + Fraccion.decimalToFraction(operandA) + "\n\n");
            System.out.println("Por favor ingrese otro valor");
            operandA = sc.nextFloat();
        } while (operandA != 0);
        sc.close();
        System.out.println(
                "Programa terminado. \n Muchas gracias por probarlo!!!");

    }
}