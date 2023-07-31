package tp;

import java.util.*;
import myinputs.Ler;

public class GerirEstatisticas {

    public static int menuE() { // Funcao do menu Aluno
        int opcao;
        System.out.println("\n\n                ### Menu das Estatisticas ###             ");
        System.out.println("   =======================================================");
        System.out.println("   |     1 - NºAlunos que moram numa determinada cidade  |");
        System.out.println("   |     2 - Cursos lecionados por mais que um professor |");
        System.out.println("   |     3 - Curso(s) mais frequentados                  |");
        System.out.println("   |     4 - Curso com mais horas                        |");
        System.out.println("   |     5 - Professor(es) com mais horas                |");
        System.out.println("   |     6 - Aluno(s) inscrito em mais cursos            |");
        System.out.println("   |     0 - Sair                                        |");
        System.out.println("   =======================================================\n");
        System.out.print("   Qual a sua opção -> ");
        opcao = Ler.umInt();
        return opcao;
    }

    //aluno inscrito em mais cursos
    public static void alunoInscritoM(ArrayList<Aluno> alunos, ArrayList<Curso> cursos) {
        int conta = 0, max = 0;
        int[] numerodevezes = new int[alunos.size()];

        for (int p = 0; p < alunos.size(); p++) { // Percorrer Lista de alunos
            conta = 0;
            for (Curso c : cursos) {    //percorrer lista de cursos
                for (Aluno aluns : c.getListaA()) { //percorrer lista de alunos dentro do curso
                    if (alunos.get(p).getNumA() == aluns.getNumA()) { //verificar se o aluno da lista de alunos, está naquele curso 
                        conta++;    //e se tiver incrementa a conta
                    }
                }
            }
            numerodevezes[p] = conta; //guarda na posião p(a posição do aluno) as
        }
        for (int i = 0; i < numerodevezes.length; i++) {
            if (numerodevezes[i] > max) {
                max = numerodevezes[i];
            }
        }
        for (int i = 0; i < numerodevezes.length; i++) {
            if (numerodevezes[i] == max) {
                System.out.println(alunos.get(i));
            }
        }

    }

    //Curso(s) com mais alunos inscritos
    public static void MaisAlunos(ArrayList<Curso> Cursos) {
        int conta = 0, max = 0, tmp;
        ArrayList<String> CursoM = new ArrayList();
        // Calcular o máximo de alunos pelo tamanho da ArrayList de Alunos pertencente ao Curso
        for (int i = 0; i < Cursos.size(); i++) {
            conta = Cursos.get(i).getListaA().size();
            tmp = conta;
            if (max < tmp) {
                max = tmp;
            }
        }
        //Ver quantos cursos têm esse numero de alunos
        for (int i = 0; i < Cursos.size(); i++) {
            if (max == Cursos.get(i).getListaA().size()) {
                CursoM.add(Cursos.get(i).getNome());
            }
        }
        for (int i = 0; i < CursoM.size(); i++) { //imprime
            System.out.println("\n   " + CursoM.get(i));
        }
    }

    //Curso(s) lecionados por mais de um professor
    public static void DoisOuMaisProfs(ArrayList<Curso> Cursos) {
        int tmp = 0;
        ArrayList<String> CursoP = new ArrayList();

        for (int i = 0; i < Cursos.size(); i++) {

            if (Cursos.get(i).getListaP().size() > 1) { //se tiver mais de dois professores impreme o nome do curso
                CursoP.add(Cursos.get(i).getNome());
                tmp = 2;
            }
        }
        if (tmp != 2) {
            System.out.println("   Não existe cursos com mais de 2 professores.");
        } else {
            for (int i = 0; i < CursoP.size(); i++) {
                System.out.println("\n   " + CursoP.get(i));
            }
        }

    }

    public static void MoraOnde(ArrayList<Aluno> Aluno) {
        System.out.print("   Insira o nome da cidade: ");
        String c = Ler.umaString().toLowerCase();
        int count = 0;                                                      //Conta o numero de alunos que moram na cidade indicada
        for (int i = 0; i < Aluno.size(); i++) {

            if (Aluno.get(i).getMorada().toLowerCase().contains(c)) {                     //Verifica se a cidade indicada está na morada do aluno
                System.out.println(Aluno.get(i));
                count = count + 1;
            }
        }
        if (count > 0) {
            System.out.println("   Há " + count + " aluno(s) na cidade: " + c); //Imprime o numero de alunos que mora na cidade indicada
        }
        if (count == 0) {
            System.out.println("   Nenhum aluno mora na cidade que indicou."); //Mensagem caso não haja alunos que moram na cidade que indicada
        }

    }

    //Função que devolve o numero de horas de um curso
    public static int HorasCurso(Curso Curso) {

        int conta = 0;
        for (int i = 0; i < Curso.getListaDias().size(); i++) {
            //Tiro a hora do inicio à hora do fim 
            conta += Curso.getListaDias().get(i).getHoraFim() - Curso.getListaDias().get(i).getHoraInicio();
        }
        return conta;
    }

    //Devolve o curso(s) com mais horas
    public static void cursoMaisHoras(ArrayList<Curso> Cursos) {
        int max = 0, tmp = 0;
        for (Curso curso : Cursos) {
            tmp = HorasCurso(curso);
            if (max < tmp) { //Verifica qual é o máximo de horas que existe num curso(s)
                max = tmp;
            }
        }
        System.out.println("\n   Os curso(s) com mais horas são: ");
        for (Curso curso : Cursos) {
            tmp = HorasCurso(curso); //Ve quais cursos tem o numero maximo de horas e imprime
            if (max == tmp) {
                System.out.println("\n   - " + curso);
            }
        }
    }

    //Quantos cursos existem
    public static int NumeroCursos(ArrayList<Curso> Cursos) {
        return Cursos.size();
    }

    //Professor com mais horas inscritas
    public static void ProfessorMaisHoras(ArrayList<Professor> ListaP, ArrayList<Curso> ListaC) { //////////////////////////
        //Criar uma Lista com os cursos que o professor está inscrito
        int conta = 0, max = 0;
        int[] horas = new int[ListaP.size()];

        for (int p = 0; p < ListaP.size(); p++) { // Percorrer Lista de professores
            conta = 0;
            for (Curso c : ListaC) {    //percorrer lista de cursos
                for (Professor prof2 : c.getListaP()) { //percorrer lista de professores dentro do curso
                    if (ListaP.get(p).getNumP() == prof2.getNumP()) { //verificar se o professor da lista de professores, está naquele curso 
                        conta += HorasCurso(c);    //e se tiver soma as horas do curso a varievel conta
                    }
                }
            }
            // debuger System.out.println(ListaP.get(p).getNome() + "conta:" + conta);
            horas[p] = conta; //guarda na posião p(a posição do professor) as horas total
        }
        for (int i = 0; i < horas.length; i++) {
            if (horas[i] > max) {
                max = horas[i];
            }
        }
        for (int i = 0; i < horas.length; i++) {
            if (horas[i] == max) {
                System.out.println(ListaP.get(i));
            }
        }

    }
}
