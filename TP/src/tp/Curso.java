package tp;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Curso implements Serializable {

    private int codigo;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private ArrayList<Dia> ListaDias;
    private ArrayList<Professor> ListaP;
    private ArrayList<Aluno> ListaA;

    Curso() {

        this.codigo = 0;
        this.nome = "";
        this.dataInicio = LocalDate.of(2021, 1, 1);
        this.dataFim = LocalDate.of(2021, 1, 1);
        this.ListaDias = new ArrayList<Dia>();
        this.ListaP = new ArrayList<Professor>();
        this.ListaA = new ArrayList<Aluno>();

    }

    Curso(int codigo, String nome) {

        this.codigo = codigo;
        this.nome = nome;
        this.dataInicio = LocalDate.of(2021, 1, 1);
        this.dataFim = LocalDate.of(2021, 1, 1);
        this.ListaDias = new ArrayList<Dia>();
        this.ListaP = new ArrayList<Professor>();
        this.ListaA = new ArrayList<Aluno>();
    }

    Curso(int codigo, String nome, ArrayList<Dia> ListaDias, ArrayList<Professor> ListaP, ArrayList<Aluno> ListaA) {

        this.codigo = codigo;
        this.nome = nome;
        this.dataInicio = LocalDate.of(2021, 1, 1);
        this.dataFim = LocalDate.of(2021, 1, 1);
        this.ListaDias = ListaDias;
        this.ListaP = ListaP;
        this.ListaA = ListaA;

    }

    public String toString() {

        String s = ("\n\n   Código do curso: " + codigo + "\n   Nome do curso: " + nome + "\n   Data de início: " + dataInicio + "\n   Data de fim: " + dataFim + "\n   Curso Lecionado por: " + ListaP + "\n   Alunos inscritos: " + ListaA);

        ArrayList<LocalDate> tmp;
        tmp = new ArrayList<>();
        ArrayList<Dia> Dias;
        Dias = new ArrayList<>();

        for (int i = 0; i < ListaDias.size(); i++) {
            tmp.add(ListaDias.get(i).getDia());
        }

        tmp.sort(Comparator.naturalOrder());
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = 0; j < ListaDias.size(); j++) {
                if (ListaDias.get(j).getDia() == tmp.get(i)) {
                    Dias.add(ListaDias.get(j));
                }
            }
        }
        this.ListaDias = Dias;
        for (int i = 0; i < ListaDias.size(); i++) {
            s += "\n   " + ListaDias.get(i);
        }
        return s;
    }

    //Getters
    public int getCodigo() {

        return codigo;

    }

    public String getNome() {

        return nome;

    }

    public LocalDate getDataInicio() {

        return dataInicio;
    }

    public LocalDate getDataFim() {

        return dataFim;
    }

    public ArrayList<Dia> getListaDias() {

        return ListaDias;
    }

    public ArrayList<Professor> getListaP() {

        return ListaP;
    }

    public ArrayList<Aluno> getListaA() {

        return ListaA;
    }

    //Setters
    public void setCodigo(int codigo) {

        this.codigo = codigo;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public void setDataInicio(int dia, int mes, int ano) {

        this.dataInicio = LocalDate.of(ano, mes, dia);

    }

    public void setDataFim(int dia, int mes, int ano) {

        this.dataFim = LocalDate.of(ano, mes, dia);

    }

    public void setListaDias(ArrayList<Dia> ListaDias) {

        this.ListaDias = ListaDias;

    }

    public void setListaP(ArrayList<Professor> ListaP) {

        this.ListaP = ListaP;

    }

    public void setListaA(ArrayList<Aluno> ListaA) {

        this.ListaA = ListaA;

    }

    // equals
    public boolean equals(Object obj) {

        if (obj != null && this.getClass() == obj.getClass()) {

            Curso c = (Curso) obj;

            boolean ig;

            ig = this.codigo == c.codigo && this.nome.equals(c.nome) && this.dataInicio.equals(c.dataInicio) && this.dataFim.equals(c.dataInicio) && this.ListaDias.equals(c.ListaDias) && this.ListaP.equals(c.ListaP) && this.ListaA.equals(c.ListaA);

            return ig;

        }
        return false;

    }

    //clone
    public Curso clone() {

        Curso copia = new Curso(this.codigo, this.nome, this.ListaDias, this.ListaP, this.ListaA);
        copia.dataInicio = this.dataInicio;
        copia.dataFim = this.dataFim;

        return copia;
    }

}
