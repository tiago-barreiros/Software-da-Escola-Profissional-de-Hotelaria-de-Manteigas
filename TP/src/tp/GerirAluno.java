package tp;

import java.io.*;
import java.util.*;
import myinputs.Ler;

public class GerirAluno {

    // Funcao do menu Aluno
    public static int menuA() {
        int opcao;
        System.out.println("\n\n       ### Menu do Gerir Aluno ###     ");
        System.out.println("   ===================================");
        System.out.println("   |     1 - Adicionar Aluno         |");
        System.out.println("   |     2 - Remover Aluno           |");
        System.out.println("   |     3 - Listar Alunos           |");
        System.out.println("   |     4 - Consultar Aluno         |");
        System.out.println("   |     5 - Editar Aluno            |");
        System.out.println("   |     0 - Sair                    |");
        System.out.println("   ===================================\n");
        System.out.print("   Qual a sua opção -> ");
        opcao = Ler.umInt();
        return opcao;
    }

    //Funcao guardar o ficheiro de aluno
    private static void guardarAluno(ArrayList<Aluno> alunos) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\tiago\\OneDrive\\Ambiente de Trabalho\\UBI\\ANO_2\\1Semestre\\ProgramacaoOrientadaaObjetos\\TrabalhoPratico\\aluno.dat"));
            // escrever o objeto Aluno no ficheiro
            os.writeObject(alunos);
            os.writeInt(Aluno.getUltimo());
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //ler ficheiro e devolver o arraylist alunos e define o ultimo número de aluno 
    public static ArrayList LerA() {
        ArrayList<Aluno> alunos = new ArrayList();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\tiago\\OneDrive\\Ambiente de Trabalho\\UBI\\ANO_2\\1Semestre\\ProgramacaoOrientadaaObjetos\\TrabalhoPratico\\aluno.dat"));
            alunos = (ArrayList) is.readObject();
            int ult = is.readInt();
            Aluno.setUltimo(ult);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return alunos;
    }

    //inserir aluno alunos no arraylist alunos
    public static void inserirAluno(ArrayList<Aluno> alunos, ArrayList<Professor> professores) {

        //Obtem dados do aluno e istancia o objeto aluno 
        System.out.println("   Preencha os seguintes dados:");
        int cc = GerirProfessor.VerificaCC(professores, alunos);
        System.out.print("   Nome: ");
        String nome = Ler.umaString();
        System.out.print("   Morada: ");
        String morada = Ler.umaString();
        System.out.print("   Telemóvel: ");
        int tele = Ler.umInt();
        Pessoa c = new Pessoa(cc, nome, morada, tele);
        Aluno l = new Aluno(c);
        alunos.add(l);      //Adiciona o novo aluno à lista
        //Atualizar ficheiro
        guardarAluno(alunos);
    }

    // Lista todos os alunos, de 5 em 5
    public static void ListarAlunos(ArrayList<Aluno> Aluno) {
        for (int i = 0; i < Aluno.size(); i++) {
            System.out.println(Aluno.get(i));
            if (i % 5 == 0 && i != 0) {
                System.out.println("   Pressione uma tecla para continuar a visualizar mais alunos ou 'q / Q' para sair.");
                String teste = Ler.umaString();
                if (teste.equalsIgnoreCase("q")) {
                    return;
                }
            }
        }
    }

    //verifica se o aluno existe e dá print sobre a informação dele
    public static void verificaAluno(ArrayList<Aluno> Aluno, String n) { // Procura o aluno com o nome indicado
        int x = 0;                                  // Guarda o indice da posição do aluno no array
        int y = 0;                                  // Variavel de controlo se há ou não alunos com nome N
        for (int i = 0; i < Aluno.size(); i++) {
            if (Aluno.get(i).getNome().equalsIgnoreCase(n)) {   // Se o aluno existir guarda a sua posição no array na variavel x 
                x = i;
                y = 1;
            }
        }
        if (y != 0) {
            y=0;
            System.out.println(Aluno.get(x).toString());  // Caso o aluno com o nome N exista no array 
        } else {
            System.out.println("   Não há alunos com o nome: " + n);   // Caso o aluno com o nome N não exista no array 
        }
        
    }

    //editar morada/nome do aluno e assim vai editar tambem nos cursos
    public static void editarAluno(ArrayList<Aluno> Alunos, ArrayList<Curso> cursos) {
        System.out.print("   Qual o número do aluno que quer alterar: ");
        int n = Ler.umInt();
        int w = 0;
        int check = 0;                                  // Variavel que verifica a existencia do aluno de nome N

        for (int i = 0; i < Alunos.size(); i++) {

            if (Alunos.get(i).getNumA() == n) {         // Se o aluno existir guarda a posição na variavel w
                w = i;
                check = 1;
            }
        }

        if (check == 0) {
            System.out.println("   O aluno de número " + n + " não existe.");     // Mensagem caso o aluno não exista
        } else {
            System.out.println("   O que deseja editar:\n   1- Nome\n   2- Morada\n");
            int escolha = Ler.umInt();
            switch (escolha) {
                case 1:
                    // Alterar nome

                    System.out.print("   Insira o novo nome: ");
                    String A = Ler.umaString();
                    Alunos.get(w).setNome(A);
                    break;
                case 2:
                    // Alterar morada

                    System.out.print("Insira a nova morada: ");
                    String M = Ler.umaString();
                    Alunos.get(w).setMorada(M);
                    break;

                default:
                    System.out.println("   Opção inválida!");
                    break;
            }
            guardarAluno(Alunos);
            ArrayList<Aluno> Aluno_curso;
            for (int i = 0; i < cursos.size(); i++) {
                Aluno_curso = cursos.get(i).getListaA();        //Procura o aluno em todas as listas de alunos de todos os cursos existentes e elimina-o

                for (int j = 0; j < Aluno_curso.size(); j++) {

                    if (Aluno_curso.get(j).getNumA() == n) { //procura o aluno com  
                        Aluno_curso.remove(j);
                        Aluno_curso.add(Alunos.get(w));
                    }
                }
                cursos.get(i).setListaA(Aluno_curso);
            }
            GerirCursos.guardarC(cursos);
        }
    }

    //remove o aluno dos cursos e do arraylist aluno
    public static void RemoveAluno(ArrayList<Aluno> Alunos, ArrayList<Curso> Cursos) {
        System.out.printf("   Qual o número do aluno que quer remover: ");
        int n = Ler.umInt();
        int x = 0;
        int y = 0; // Variavel de controlo se há ou não alunos com nome N
        for (int i = 0; i < Alunos.size(); i++) {

            if (Alunos.get(i).getNumA() == n) {     // Encontra o aluno com o nome N no Array e guarda a sua posição na variavel x
                x = i;
                y = 1;
            }
        }
        if (y == 0) {
            System.out.println("   O aluno de número " + n + " não existe.");     // Mensagem caso o aluno procurado não exista.
        } else {
            Alunos.remove(x);
            System.out.println("   Aluno removido com sucesso!");
            guardarAluno(Alunos);
            ArrayList<Aluno> Aluno_curso;
            for (int i = 0; i < Cursos.size(); i++) {
                Aluno_curso = Cursos.get(i).getListaA();        //Procura o aluno em todas as listas de alunos de todos os cursos existentes e elimina-o

                for (int j = 0; j < Aluno_curso.size(); j++) {

                    if (Aluno_curso.get(j).getNumA() == n) {
                        Aluno_curso.remove(j);
                    }
                }
                Cursos.get(i).setListaA(Aluno_curso);
            }
            GerirCursos.guardarC(Cursos);    //Guarda as alterações nas listas dos alunos dos cursos
        }
    }
}
