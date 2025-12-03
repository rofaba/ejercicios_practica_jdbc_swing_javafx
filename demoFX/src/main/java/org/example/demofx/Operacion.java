package org.example.demofx;

public class Operacion {
    private int ope1;
    private int ope2;
    private double resultado = 0;

    public Operacion(int ope1, int ope2) {
        this.ope1 = ope1;
        this.ope2 = ope2;
    }

    public int getOpe1() {
        return ope1;
    }

    public void setOpe1(int ope1) {
        this.ope1 = ope1;
    }

    public int getOpe2() {
        return ope2;
    }

    public void setOpe2(int ope2) {
        this.ope2 = ope2;
    }


    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


    public int sumar(int ope1, int ope2) {
        resultado = ope1 + ope2;
        return (int) resultado;
    }
    public int restar(int ope1, int ope2) {
        resultado = ope1 - ope2;
        return (int) resultado;

    }
    public int multiplicar(int ope1, int ope2) {
        resultado = ope1 * ope2;
        return (int) resultado;

    }
    public double dividir(int ope1, int ope2) {
        resultado = ((double) (ope1/ope2));
        return resultado;
    }
}

