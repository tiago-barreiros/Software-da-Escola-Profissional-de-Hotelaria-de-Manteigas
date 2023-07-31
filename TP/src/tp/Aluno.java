package tp;

import java.io.*;


public class Aluno extends Pessoa implements Serializable {

    private int NumA;
    private static int ultimo = 0;

    public Aluno(Pessoa b) {
        super(b.getCC(), b.getNome(), b.getMorada(), b.getPhone());
        ultimo = ultimo + 1;
        this.NumA = ultimo;
    }

    public int getNumA() {
        return NumA;
    }

    public void setNumA(int NumA) {
        this.NumA = NumA;
    }
      public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Aluno.ultimo = ultimo;
    }

    public String toString() {
        return super.toString() + "\n   Dados Academicos:" + "\n   Número de Aluno: " + this.NumA;
    }

    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            Aluno x = (Aluno) obj;
            return (super.equals(x) && this.NumA == x.NumA);
        } else {
            return false;
        }
    }

    public Object clone() {
        Pessoa x = new Pessoa(super.getCC(), super.getNome(), super.getMorada(), super.getPhone());

        Aluno copia = new Aluno(x);
        copia.setNumA(this.NumA);

        return copia;
    }
}
