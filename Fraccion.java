public class Fraccion {
    private final int numerador;
    private final int denominador;

    public Fraccion(int numerador, int denominador) {

        validarDenominadorNulo(denominador);
        if (denominador < 0) {
            denominador = denominador * -1;
            numerador = numerador * -1;
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(float numerador, float denominador) { // Necesita que decimalToFraction este habilitado ademas de
                                                          // agregarla mas logica
        validarDenominadorNulo(denominador);

        this.numerador = (int) numerador;
        this.denominador = (int) denominador;
    }

    public static Fraccion decimalToFraction(float operando) {// ! Pueden haber inconsistencias por la falta de
                                                              // presicion de float. Tener en cuanta pasar de float a
                                                              // BigInteger o BigDecimial

        if (operando == 0.0) {
            return new Fraccion(0, 1);
        }
        Fraccion fractionReturned;
        int parteEntera = (int) operando;
        float parteDecimal = operando - parteEntera;

        if (parteDecimal != 0) {
            float aux = 100 / parteDecimal;
            Fraccion fraccionParteDecimal = new Fraccion(100, aux).simplicarFraccion();

            if (parteEntera != 0) {
                Fraccion fraccionParteEntera = new Fraccion(Math.abs(parteEntera), 1);
                fractionReturned = new Fraccion(
                        (fraccionParteDecimal.getNumerador() + fraccionParteEntera.getNumerador()) * (Math
                                .abs(parteEntera)
                                / parteEntera),
                        fraccionParteDecimal.getDenominador() + fraccionParteEntera.getDenominador());
            }
            fractionReturned = fraccionParteDecimal;
        } else {
            Fraccion fraccionParteEntera = new Fraccion(parteEntera, 1);

            fractionReturned = fraccionParteEntera;
        }

        return fractionReturned;
    }

    private void validarDenominadorNulo(float denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador NO puedo ser cero (0)");
        }
    }

    public Fraccion simplicarFraccion() {
        int valorMCD = mcd(this.numerador, this.denominador);

        return new Fraccion(this.numerador / valorMCD, this.denominador / valorMCD);
    }

    public int mcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int mcm(int operandoA, int operandoB) {

        return (Math.abs(operandoB * operandoA)) / (mcd(operandoA, operandoB));

    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    @Override
    public String toString() {
        return "\n" + String.valueOf(this.numerador) + "\n-\n" + String.valueOf(this.denominador) + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Fraccion) {
            Fraccion miFraccionComparar = (Fraccion) obj;
            if (this.simplicarFraccion().numerador == miFraccionComparar.simplicarFraccion().numerador
                    && this.simplicarFraccion().denominador == miFraccionComparar.simplicarFraccion().denominador) {
                resultado = true;
            }
        }
        return resultado;
    }

}
