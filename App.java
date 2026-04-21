import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println(
        // "Binvenido/a la calculadora basica de fraccions!! \n\n Por favor ingrese dos
        // operandos, uno despues del otro a traves del enter para empezar a probar");
        // int operandA = sc.nextInt();
        // int operandB = sc.nextInt();
        // Fraccion miFraccion = new Fraccion(operandA, operandB);
        // System.out.println(
        // miFraccion + "\n\n\n A continuacion aparcera la version simplificada" +
        // miFraccion.simplicarFraccion());
        int variable = -3;
        System.out.println("Probando igualacion de fracciones" + new Fraccion(82, 9).equals(new Fraccion(9, 1)));
    }
}