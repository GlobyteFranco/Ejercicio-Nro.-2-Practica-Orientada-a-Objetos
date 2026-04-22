import java.util.Scanner;

public class Gestor {// !Esta clase deberia ser generica para todos los tipos de calculadoras y no
                     // estar especializada en la calculadora Fraccion. En cualquier caso deberia
                     // haber una clase aparte que se encargue de esta
    Calculadora<Fraccion> calculadoraGestor; // Eventualmente podria ser una lista de calculadoras y elegir la que mas
                                             // le
    // convenga
    Fraccion fraccionA;
    Fraccion fraccionB;
    Fraccion resultado;

    float operandA;
    float operandB;
    Scanner sc = new Scanner(System.in);

    public Gestor(Calculadora<Fraccion> calculadoraGestor) {
        this.calculadoraGestor = calculadoraGestor;
    }

    public Calculadora<Fraccion> getCalculadoraGestor() {
        return calculadoraGestor;
    }

    public void ingresarFracciones() {
        System.out.println("A continuacion ingrese los valores para la primera fraccion: \n\n");
        operandA = sc.nextFloat();
        operandB = sc.nextFloat();
        fraccionA = new Fraccion(operandA, operandB).simplicarFraccion();
        System.out.println("\n\n Ahora para la segunda fraccion: \n\n");
        operandA = sc.nextFloat();
        operandB = sc.nextFloat();
        fraccionB = new Fraccion(operandA, operandB).simplicarFraccion();
        System.out.println("\n\n Muchas gracias");
        mostrarFracciones();
        desplegarMenu();

    }

    public void mostrarFracciones() {
        validarIngresoFracciones();
        System.out.println("Los valores de las fracciones son los siguientes: \n\n Primera Fraccion -->   " + fraccionA
                + "\n\n Segunda Fraccion -->   " + fraccionB);
        desplegarMenu();
    }

    public void validarIngresoFracciones() {
        if (fraccionA == null) {
            System.out.println("Se necesita que la primera fraccion sea inicializada, a continuacion ingresela\n");
            operandA = sc.nextFloat();
            operandB = sc.nextFloat();
            fraccionA = new Fraccion(operandA, operandB);
            return;
        } else if (fraccionB == null) {
            System.out.println("Se necesita que la segunda fraccion sea inicializada, a continuacion ingresela\n");
            operandA = sc.nextFloat();
            operandB = sc.nextFloat();
            fraccionB = new Fraccion(operandA, operandB);
            return;
        }
    }

    public void salir() {
        sc.close();
        System.out.println("Saliendo..."); // TODO: Hacer la logica de finalizacion de programa
    }

    public void mostrarResultado(Fraccion fraccionResultado) {
        System.out.println("El resultado es" + fraccionResultado);
    }

    public void desplegarMenu() {
        System.out.println(
                "Elija una opcion ingresando su numero por consola\n [1]INGRESAR FRACCIONES\n\n[2]SUMAR\n\n[3]RESTAR\n\n[4]MULTIPLICAR\n\n[5]DIVIDIR\n\n[6]MOSTRAR FRACCIONES\n\n[7]SALIR");

        operandA = sc.nextFloat();
        switch ((int) operandA) {
            case 1:
                ingresarFracciones();
                break;
            case 2:
                validarIngresoFracciones();
                mostrarResultado(calculadoraGestor.sumar(fraccionA, fraccionB));
                break;
            case 3:
                validarIngresoFracciones();
                mostrarResultado(calculadoraGestor.restar(fraccionA, fraccionB));
                break;
            case 4:
                validarIngresoFracciones();
                mostrarResultado(calculadoraGestor.multiplicar(fraccionA, fraccionB));
                break;
            case 5:
                validarIngresoFracciones();
                mostrarResultado(calculadoraGestor.dividir(fraccionA, fraccionB));
                break;
            case 6:
                mostrarFracciones();
                break;
            case 7:
                salir();
                break;

            default:
                System.out.println("No se ha elegido una opcion valida, por favor intentelo de nuevo");
                desplegarMenu();
                break;
        }
    }

    // TODO: Completar la logica
    public void comenzarCalculadora() {
        desplegarMenu();

    }

}
