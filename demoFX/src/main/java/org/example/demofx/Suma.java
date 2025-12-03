package org.example.demofx;

public class Suma {
    private int ope1;
    private int ope2;

    public Suma(int ope1, int ope2){
        this.ope1 = ope1;
        this.ope2 = ope2;
    }
    public int getResultado(){
        return ope1 + ope2;
    }

}
