package br.pucpr.formas;

public abstract class Forma {
    enum Cor {

    }
    private Cor cor;
    public abstract double getPerimetro();
    public abstract double getArea();

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}
