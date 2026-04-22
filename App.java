
public class App {
    public static void main(String[] args) {
        Calculadora calculadoraActiva = new CalculadoraFraccion();
        Gestor miGestor = new Gestor(calculadoraActiva);
        miGestor.comenzarCalculadora();

    }
}