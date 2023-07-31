package tp;

import java.io.*;

public class Professor extends Pessoa implements Serializable {

    private int NumP;
    private static int ultimo = 0;
// Pode se meter as cadeiras que ele dá aqui talvez

    public Professor(Pessoa x) {
        super(x.getCC(), x.getNome(), x.getMorada(), x.getPhone());
        ultimo = ultimo + 1;
        this.NumP = ultimo;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Professor.ultimo = ultimo;
    }

    public int getNumP() {
        return NumP;
    }

    public void setNumP(int NumP) {
        this.NumP = NumP;
    }

    public String toString() {
        return super.toString() + "\n   Dados Academicos:" + "\n   Número de Professor: " + this.NumP;
    }

    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            Professor x = (Professor) obj;
            return (super.equals(x) && this.NumP == x.NumP);
        } else {
            return false;
        }
    }

    public Object clone() {
        Pessoa x = new Pessoa(super.getCC(), super.getNome(), super.getMorada(), super.getPhone());

        Professor copia = new Professor(x);
        copia.setNumP(this.NumP); //POIS temos de meter o mesmo número de aluno. 

        //copia.setcursos(this.cursos); SE METER ARAYLIST DE CURSOS COMO ATRIBUTO
        return copia;
    }

}
