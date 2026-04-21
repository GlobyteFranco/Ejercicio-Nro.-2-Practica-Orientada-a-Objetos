public class CalculadoraFraccion implements Calculadora<Fraccion> {

    @Override
    public Fraccion sumar(Fraccion a, Fraccion b) {
        if (a.getNumerador() == 0 || b.getNumerador() == 0) {
            if (a.getNumerador() == 0) {
                return b;
            } else if (b.getNumerador() == 0) {
                return a;
            }
        }
        if (a.getDenominador() == b.getDenominador()) {
            return new Fraccion(a.getNumerador() + b.getNumerador(), a.getDenominador());
        } else {
            return new Fraccion(a.getNumerador() * b.getDenominador() + b.getNumerador() * a.getDenominador(),
                    a.getDenominador() * b.getDenominador());
        }
    }

    @Override
    public Fraccion restar(Fraccion a, Fraccion b) {
        if (a.getNumerador() == 0 || b.getNumerador() == 0) {
            if (a.getNumerador() == 0) {
                return new Fraccion(b.getNumerador() * -1, b.getDenominador());
            } else if (b.getNumerador() == 0) {
                return a;
            }
        }
        if (a.getDenominador() == b.getDenominador()) {
            return new Fraccion(a.getNumerador() - b.getNumerador(), a.getDenominador());
        } else {
            return new Fraccion(a.getNumerador() * b.getDenominador() - b.getNumerador() * a.getDenominador(),
                    a.getDenominador() * b.getDenominador());
        }
    }

    @Override
    public Fraccion multiplicar(Fraccion a, Fraccion b) {
        return new Fraccion(a.getNumerador() * b.getNumerador(), a.getDenominador() * b.getDenominador());
    }

    @Override
    public Fraccion dividir(Fraccion a, Fraccion b) {
        if (b.getNumerador() == 0) {
            throw new IllegalArgumentException("No es posible dividir por una fraccion nula");
        }
        return new Fraccion(a.getNumerador() * b.getDenominador(), a.getDenominador() * b.getNumerador());
    }
    // FALTAN TEST UNITARIOS !!!
}
